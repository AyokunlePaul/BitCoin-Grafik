package com.ayokunlepaul.local.utils

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

inline fun <reified DATABASE : RoomDatabase> database(
    context: Context,
    block: RoomDatabase.Builder<DATABASE>.() -> Unit
): DATABASE {
    val builder = Room.databaseBuilder(
        context,
        DATABASE::class.java,
        BlockchainGraphLocalConstants.BLOCKCHAIN_DATABASE_NAME
    )
    builder.apply(block)
    return builder.build()
}