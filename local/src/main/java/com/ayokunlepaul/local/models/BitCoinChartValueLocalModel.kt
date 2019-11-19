package com.ayokunlepaul.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BITCOIN VALUE TABLE")
data class BitCoinChartValueLocalModel (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val xAxis: String,
    val yAxis: String
)