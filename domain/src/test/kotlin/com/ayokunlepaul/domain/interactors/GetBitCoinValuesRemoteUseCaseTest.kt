package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.interactors.utils.Creator
import com.ayokunlepaul.domain.models.BitCoinChartValue
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class GetBitCoinValuesRemoteUseCaseTest {

    @MockK
    private lateinit var scheduler: BitCoinGrafikScheduler

    @MockK
    private lateinit var domain: BitCoinGrafikDomain

    private val useCase by lazy { GetBitCoinValuesRemoteUseCase(scheduler, domain) }
    private val chartValue = Creator.create()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        every { scheduler.observationThread } returns TestScheduler()
        every { scheduler.executionThread } returns TestScheduler()
    }

    @Test
    fun testUseCaseExecutionSuccessful() {
        every { domain.getBitCoinGrafikValueRemote() } returns Single.just(chartValue)
        val testObserver = useCase.buildSingleUseCase().test()
        testObserver.assertComplete()
    }

    @Test
    fun `test that getBitCoinGrafikValueRemote is called`() {
        every { domain.getBitCoinGrafikValueRemote() } returns Single.just(chartValue)
        val testObserver = useCase.buildSingleUseCase().test()
        testObserver.assertComplete()
        verify (exactly = 1) { domain.getBitCoinGrafikValueRemote() }
    }
}