package com.ayokunlepaul.core.di

import com.ayokunlepaul.core.di.modules.BitCoinGraphFactoryModule
import com.ayokunlepaul.core.di.modules.ContextModule
import com.ayokunlepaul.core.di.modules.UtilityModule
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import com.ayokunlepaul.remote.di.RemoteImplModule
import com.ayokunlepaul.remote.di.RetrofitModule
import com.ayokunlepaul.remote.di.ServiceModule
import dagger.Component

@Component(
    modules = [
        ContextModule::class, UtilityModule::class,
        RetrofitModule::class, RemoteImplModule::class,
        ServiceModule::class, BitCoinGraphFactoryModule::class
    ]
)
interface BitCoinGrafikCoreComponent {

    fun scheduler(): BitCoinGrafikScheduler
    fun domain(): BitCoinGrafikDomain

    @Component.Builder
    interface Builder {
        fun provideContextModule(module: ContextModule): Builder
        fun buildBlockchainCoreComponent(): BitCoinGrafikCoreComponent
    }
}