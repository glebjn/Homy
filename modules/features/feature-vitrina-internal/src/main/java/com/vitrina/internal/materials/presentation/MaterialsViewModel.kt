package com.vitrina.internal.materials.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitrina.internal.materials.domain_api.GetMaterialsUseCase
import com.vitrina.internal.materials.domain_impl.MaterialFlowRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MaterialsViewModel(
    private val getMaterialsUseCase: GetMaterialsUseCase,
    private val repository: MaterialFlowRepository
) : ViewModel() {

    private val uiModelsInternal = MutableStateFlow(MaterialsUiModel())
    val uiModels = uiModelsInternal.asStateFlow()

    init {
        accept(MaterialIntent.Init)
    }

    private fun getMaterials() {
        viewModelScope.launch {
            val result = getMaterialsUseCase()
            result.onSuccess { materials ->
                val uiModels = materials.map { model ->
                    MaterialUiModel(
                        header = model.name,
                        description = "My price is ${model.price}"
                    )
                }
                uiModelsInternal.emit(MaterialsUiModel(materials = uiModels))
            }
            result.onFailure { throwable ->
                uiModelsInternal.emit(MaterialsUiModel(errorText = "Result error message = ${throwable.message}"))
            }
        }
    }

    fun accept(intent: MaterialIntent) {
        when (intent) {
            is MaterialIntent.Init -> getMaterials()
            is MaterialIntent.Refresh -> getMaterials()
        }
    }

    fun flowExperiment1() {
        viewModelScope.launch {
            repository.getMaterialList()
                .map { MaterialIntent.GetMaterialSuccess(materials = it) }
                .catch<MaterialIntent> { emit(MaterialIntent.GetMaterialError(throwable = it)) }
                .collect { intent ->
                    when(intent) {
                        is MaterialIntent.GetMaterialSuccess -> {}
                        is MaterialIntent.GetMaterialError -> {}
                        else -> {}
                    }
                }
        }
    }

    fun flowExperiment2() {
        viewModelScope.launch {
            repository.getMaterialList()
                .map { Result.success(it) }
                .catch { emit(Result.failure(it)) }
                .collect { result ->
                    when {
                        result.isSuccess -> { result.getOrDefault(emptyList()) }
                        result.isFailure -> { result.exceptionOrNull() }
                    }
                }
        }
    }
}