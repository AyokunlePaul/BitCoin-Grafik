package com.ayokunlepaul.remote.services

import com.ayokunlepaul.remote.model.BaseBitcoinGrafikRemoteModel
import com.ayokunlepaul.remote.model.BlockchainChartValueRemoteModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BitcoinGrafikService {

    @GET("charts/{chartName}")
    fun getCharts(@Path("chartName") chartName: String): Single<BaseBitcoinGrafikRemoteModel<List<BlockchainChartValueRemoteModel>>>
}