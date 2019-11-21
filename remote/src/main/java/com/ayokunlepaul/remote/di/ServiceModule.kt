package com.ayokunlepaul.remote.di

import com.ayokunlepaul.remote.services.BitCoinGrafikChartService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ServiceModule {

    @Provides
    internal fun bindGrafikService(
        retrofit: Retrofit
    ): BitCoinGrafikChartService {
        return retrofit.create(BitCoinGrafikChartService::class.java)
    }
}