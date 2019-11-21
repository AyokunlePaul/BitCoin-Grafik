package com.ayokunlepaul.repository

import com.ayokunlepaul.repository.impl.BitCoinRepositoryImpl
import com.ayokunlepaul.repository.utils.Creator
import io.mockk.MockKAnnotations
import io.mockk.MockKException
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

class BitCoinRepositoryImplTest {

    @MockK
    lateinit var local: BitCoinGrafikRepository
    @MockK
    lateinit var remote: BitCoinGrafikRepository
    private val impl by lazy { BitCoinRepositoryImpl(local, remote) }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `test that call to local works correctly`() {
        every { local.getBitCoinValuesLocal() } returns Observable.just(Creator.create())
        val testObserver = impl.getBitCoinGrafikValueLocal().test()
        testObserver.assertComplete()

        verify(exactly = 1) { local.getBitCoinValuesLocal() }
    }

    @Test(expected = MockKException::class)
    fun `verify that trying to access remote implementation from local throws exception`() {
        every { local.getBitCoinValuesRemote() } throws IllegalStateException("Implementation doesn't exist in this module")
        every { local.getBitCoinValuesLocal() } returns Observable.just(Creator.create())
        val testObserver = impl.getBitCoinGrafikValueRemote().test()
        testObserver.assertComplete()

        verify(exactly = 1) { local.getBitCoinValuesRemote() }
    }
}