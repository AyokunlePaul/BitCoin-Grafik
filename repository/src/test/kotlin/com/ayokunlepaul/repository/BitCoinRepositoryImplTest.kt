package com.ayokunlepaul.repository

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before

class BitCoinRepositoryImplTest {

    @MockK
    lateinit var local: BitCoinGrafikRepository

    @MockK
    lateinit var remote: BitCoinGrafikRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    
}