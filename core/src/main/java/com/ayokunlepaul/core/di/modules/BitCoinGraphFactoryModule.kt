package com.ayokunlepaul.core.di.modules

import androidx.lifecycle.ViewModelProvider
import com.ayokunlepaul.core.factory.BitcoinGrafikViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BitCoinGraphFactoryModule {

    @Binds
    @Singleton
    internal abstract fun bindBlockchainGraphViewModelFactory(
        factory: BitcoinGrafikViewModelFactory
    ): ViewModelProvider.Factory
}