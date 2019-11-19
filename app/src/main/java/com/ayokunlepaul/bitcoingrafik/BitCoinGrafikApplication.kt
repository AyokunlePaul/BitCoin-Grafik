package com.ayokunlepaul.bitcoingrafik

import com.ayokunlepaul.bitcoingrafik.di.DaggerBitCoinGrafikApplicationComponent
import com.ayokunlepaul.core.di.DaggerBitCoinGrafikCoreComponent
import com.ayokunlepaul.core.di.modules.ContextModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class BitCoinGrafikApplication : DaggerApplication() {

    private val coreComponent by lazy {
        DaggerBitCoinGrafikCoreComponent.builder()
            .provideContextModule(ContextModule(applicationContext))
            .buildBlockchainCoreComponent()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerBitCoinGrafikApplicationComponent.builder()
            .bitCoinGrafikCoreComponent(coreComponent)
            .build()
    }
}