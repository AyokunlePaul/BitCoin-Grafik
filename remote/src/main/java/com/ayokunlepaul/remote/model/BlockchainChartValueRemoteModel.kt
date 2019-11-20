package com.ayokunlepaul.remote.model

import com.google.gson.annotations.SerializedName

data class BlockchainChartValueRemoteModel(
    @SerializedName("x") val xAxis: String,
    @SerializedName("y") val yAxis: String
)