package com.ayokunlepaul.local.di

import android.content.Context
import com.ayokunlepaul.local.room.BlockchainGrafikDatabase
import com.ayokunlepaul.local.room.dao.BitCoinValueDao
import com.ayokunlepaul.local.utils.database
import dagger.Module
import dagger.Provides

@Module
class BitCoinDatabaseModule {

    @Provides
    internal fun provideBlockchainGrafikDatabase(context: Context): BlockchainGrafikDatabase {
        return database(context) {
            allowMainThreadQueries()
            fallbackToDestructiveMigration()
        }
    }

    @Provides
    internal fun provideBlockchainValueDao(
        database: BlockchainGrafikDatabase
    ): BitCoinValueDao = database.getBlockChainValueDao()
}