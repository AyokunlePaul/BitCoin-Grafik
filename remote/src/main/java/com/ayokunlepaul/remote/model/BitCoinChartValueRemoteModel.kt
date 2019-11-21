package com.ayokunlepaul.remote.model

import com.google.gson.annotations.SerializedName

data class BitCoinChartValueRemoteModel(
    @SerializedName("x") val xAxis: String,
    @SerializedName("y") val yAxis: String
)