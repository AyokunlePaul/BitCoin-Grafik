package com.ayokunlepaul.remote.model

import com.google.gson.annotations.SerializedName

data class BaseBitcoinGrafikRemoteModel <DATA> (
    @SerializedName("values") val data: DATA,
    val status: String,
    val unit: String
)