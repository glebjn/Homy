package com.vitrina.internal.materials.presentation

import com.vitrina.internal.materials.domain_api.MaterialModel

sealed class MaterialIntent {
    object Init : MaterialIntent()
    object Refresh : MaterialIntent()

    data class GetMaterialSuccess(val materials: List<MaterialModel>) : MaterialIntent()
    data class GetMaterialError(val throwable: Throwable) : MaterialIntent()
}

data class MaterialState(
    val materials: List<MaterialModel>,
    val exception: Exception
)

data class MaterialsUiModel(
    val materials: List<MaterialUiModel> = emptyList(),
    val errorText: String = ""
)

data class MaterialUiModel(
    val header: String,
    val description: String
)