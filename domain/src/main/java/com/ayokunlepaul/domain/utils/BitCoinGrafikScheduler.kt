package com.ayokunlepaul.domain.utils

import io.reactivex.Scheduler

interface BitCoinGrafikScheduler {
    val observationThread: Scheduler
    val executionThread: Scheduler
}