package com.ayokunlepaul.core.di.modules

import com.ayokunlepaul.core.utils.BlockchainGrafikSchedulerImpl
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import com.ayokunlepaul.repository.impl.BlockchainRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UtilityModule {

    @Binds
    internal abstract fun bindBlockchainGrafikScheduler(
        impl: BlockchainGrafikSchedulerImpl
    ): BitCoinGrafikScheduler

    @Binds
    internal abstract fun bindBlockchainGrafikDomain(
        impl: BlockchainRepositoryImpl
    ): BitCoinGrafikDomain
}