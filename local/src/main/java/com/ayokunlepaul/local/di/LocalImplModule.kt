package com.ayokunlepaul.local.di

import com.ayokunlepaul.local.impl.BlockchainLocalImpl
import com.ayokunlepaul.repository.BitCoinGrafikRepository
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class LocalImplModule {

    @Binds
    @Named("LOCAL")
    internal abstract fun bindBlockchainGrafik(
        impl: BlockchainLocalImpl
    ): BitCoinGrafikRepository
}