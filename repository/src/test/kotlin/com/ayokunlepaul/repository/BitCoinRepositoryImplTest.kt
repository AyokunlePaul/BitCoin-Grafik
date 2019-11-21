package com.ayokunlepaul.repository

import com.ayokunlepaul.repository.impl.BitCoinRepositoryImpl
import com.ayokunlepaul.repository.utils.Creator
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before

class BitCoinRepositoryImplTest {

    @MockK
    lateinit var remote: BitCoinGrafikRepository
    private val impl by lazy { BitCoinRepositoryImpl(remote) }

    private val charts by lazy { Creator.create() }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

//    @Test
//    fun `verify that remote implementation returns the expected result`() {
//        every { remote.getBitCoinValuesRemote() } returns Single.just(charts)
//        val emittedValues = mutableListOf<BitCoinChartValueEntity>()
//        val testObserver = impl.getBitCoinGrafikValueRemote().map {
//            it.map { value -> BitCoinChartValueEntity(xAxis = value.xAxis, yAxis = value.yAxis) }
//        }.doOnSuccess {
//            emittedValues.addAll(it)
//        }.test()
//        assertEquals(charts, emittedValues)
//        testObserver.assertComplete()
//    }
}