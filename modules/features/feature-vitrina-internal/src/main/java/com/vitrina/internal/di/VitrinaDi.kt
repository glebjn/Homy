package com.vitrina.internal.di

import com.vitrina.internal.materials.domain_api.GetMaterialsUseCase
import com.vitrina.internal.materials.domain_impl.MaterialRepositoryImpl
import com.vitrina.internal.materials.domain_impl.MaterialsRepository
import com.vitrina.internal.materials.presentation.MaterialsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vitrinaDi = module {
    viewModel { MaterialsViewModel(get(), get()) }

    // domain
    factory { GetMaterialsUseCase(get()) }

    // data
    factory<MaterialsRepository> { MaterialRepositoryImpl(get()) }
}