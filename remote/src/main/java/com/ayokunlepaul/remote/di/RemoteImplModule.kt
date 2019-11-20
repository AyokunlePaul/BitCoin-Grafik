package com.ayokunlepaul.remote.di

import com.ayokunlepaul.remote.impl.BitCoinGrafikRemoteImpl
import com.ayokunlepaul.repository.BitCoinGrafikRepository
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class RemoteImplModule {

    @Binds
    @Named("REMOTE")
    internal abstract fun bindBitcoinGrafikRemote(
        impl: BitCoinGrafikRemoteImpl
    ): BitCoinGrafikRepository
}