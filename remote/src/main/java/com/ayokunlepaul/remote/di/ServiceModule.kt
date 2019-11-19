package com.ayokunlepaul.remote.di

import com.ayokunlepaul.remote.services.BitcoinGrafikService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ServiceModule {

    @Provides
    internal fun bindGrafikService(
        retrofit: Retrofit
    ): BitcoinGrafikService {
        return retrofit.create(BitcoinGrafikService::class.java)
    }
}