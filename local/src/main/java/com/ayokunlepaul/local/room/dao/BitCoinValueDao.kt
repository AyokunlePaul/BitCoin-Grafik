package com.ayokunlepaul.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayokunlepaul.local.models.BitCoinChartValueLocalModel
import io.reactivex.Observable

@Dao
interface BitCoinValueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveBitCoinValue(value: BitCoinChartValueLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveBitCoinValues(value: List<BitCoinChartValueLocalModel>)

    @Query("SELECT * FROM `BITCOIN VALUE TABLE`")
    fun observeBitCoinValueTable(): Observable<List<BitCoinChartValueLocalModel>>

    @Query("SELECT COUNT(*) FROM `BITCOIN VALUE TABLE`")
    fun getBitCoinValueTableSize(): Int
}