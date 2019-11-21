package com.ayokunlepaul.bitcoingrafik.presentation.viewmodels

import com.ayokunlepaul.bitcoingraph.BitCoinGrafik
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainFragmentViewModelTest {

    @MockK
    lateinit var grafik: BitCoinGrafik

    private val viewModel by lazy { MainFragmentViewModel(grafik) }

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @After
    fun tearDown() {
        grafik.cleanUp()
    }

    @Test
    fun getBitCoinValues() {
        val type = "n-transaction"
        val span = "20days"

        viewModel.setStatType(type, span)

        every { grafik.getBitCoinValuesRemote(any(), any(), any()) } just Runs

        viewModel.getBitCoinValues()

        verify(exactly = 1) { grafik.getBitCoinValuesRemote(any(), any(), any()) }
    }

    @Test
    fun getErrorMessage() {
    }

    @Test
    fun setErrorMessage() {
    }

    @Test
    fun setStatType() {
        val type = "n-transaction"
        val span = "20days"
        viewModel.setStatType(type, span)
        assertEquals(viewModel.bitCoinChartQueryModel.span, span)
        assertEquals(viewModel.bitCoinChartQueryModel.statType, type)
    }
}