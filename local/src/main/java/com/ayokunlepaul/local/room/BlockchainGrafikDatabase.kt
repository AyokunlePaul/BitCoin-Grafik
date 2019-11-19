package com.ayokunlepaul.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayokunlepaul.local.BuildConfig
import com.ayokunlepaul.local.models.BitCoinChartValueLocalModel
import com.ayokunlepaul.local.room.dao.BitCoinValueDao

@Database(
    version = BuildConfig.VERSION_CODE,
    entities = [
        BitCoinChartValueLocalModel::class
    ]
)
internal abstract class BlockchainGrafikDatabase : RoomDatabase() {

    abstract fun getBlockChainValueDao(): BitCoinValueDao
}