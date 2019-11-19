package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.interactors.utils.Creator
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test


class GetBitCoinValuesLocalUseCaseTest {

    @MockK
    private lateinit var domain: BitCoinGrafikDomain

    @MockK
    private lateinit var scheduler: BitCoinGrafikScheduler

    private val useCase by lazy { GetBitCoinValuesLocalUseCase(scheduler, domain) }

    private val chartValue = Creator.create()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        every { scheduler.observationThread } returns TestScheduler()
        every { scheduler.executionThread } returns TestScheduler()
    }

    @Test
    fun testUseCaseExecutionSuccessful() {
        every { domain.getBitCoinGrafikValueLocal() } returns Observable.just(chartValue)
        val testObserver = useCase.buildObservableUseCase().test()
        testObserver.assertComplete()
    }

    @Test
    fun `test that getBitCoinGrafikValueLocal is called`() {
        every { domain.getBitCoinGrafikValueLocal() } returns Observable.just(chartValue)
        val testObserver = useCase.buildObservableUseCase().test()
        testObserver.assertComplete()
        verify (exactly = 1) { domain.getBitCoinGrafikValueLocal() }
    }
}