package com.ayokunlepaul.remote.di

import com.ayokunlepaul.remote.impl.BlockchainRemoteImpl
import com.ayokunlepaul.repository.BlockchainGrafikRepository
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class RemoteImplModule {

    @Binds
    @Named("REMOTE")
    internal abstract fun bindBitcoinGrafikRemote(
        impl: BlockchainRemoteImpl
    ): BlockchainGrafikRepository
}