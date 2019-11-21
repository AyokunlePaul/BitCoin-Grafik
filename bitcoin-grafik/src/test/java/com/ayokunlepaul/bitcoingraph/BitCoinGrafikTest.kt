package com.ayokunlepaul.bitcoingraph

import com.ayokunlepaul.bitcoingraph.utils.Creator
import com.ayokunlepaul.domain.interactors.GetBitCoinValuesRemoteUseCase
import com.ayokunlepaul.domain.models.BitCoinChartValue
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BitCoinGrafikTest {

    @MockK
    lateinit var useCase: GetBitCoinValuesRemoteUseCase

    private val grafik by lazy { BitCoinGrafik(useCase) }
    private val testChartData = Creator.create()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun getBitCoinValuesRemote() {
        val type = "market-price"
        val span = "30days"

        every { useCase.buildSingleUseCase() } returns Single.just(testChartData)
        val emittedValue = mutableListOf<BitCoinChartValue>()
        grafik.getBitCoinValuesRemote(type, span) {
            emittedValue.addAll(it.getOrDefault(emptyList()))
            assert(it.isSuccess)
            assertEquals(testChartData, emittedValue)
        }
    }

    @Test
    fun cleanUp() {

    }
}