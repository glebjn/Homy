package com.glebjay.designsystem.di

import com.glebjay.designsystem.data.DesignSystemRepositoryImpl
import com.glebjay.designsystem.domain.ButtonProvider
import com.glebjay.designsystem.domain.ButtonUiModel
import com.glebjay.designsystem.domain.DesignSystemRepository
import com.glebjay.designsystem.domain.Provider
import org.koin.dsl.module

val designSystemDi = module {
    single<DesignSystemRepository> { DesignSystemRepositoryImpl() }
    single<Provider<ButtonUiModel>> { ButtonProvider(get()) }
}