package com.glebjay.designsystem

import android.app.Application
import com.glebjay.designsystem.di.designSystemDi
import org.koin.core.context.startKoin

class DesignSystemApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(designSystemDi)
        }
    }
}