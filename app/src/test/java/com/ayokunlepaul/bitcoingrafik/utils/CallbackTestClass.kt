package com.ayokunlepaul.bitcoingrafik.utils

import com.ayokunlepaul.domain.models.BitCoinChartValue

class CallbackTestClass : ((Result<List<BitCoinChartValue>>) -> Unit) {

    private lateinit var value: List<BitCoinChartValue>

    override fun invoke(p1: Result<List<BitCoinChartValue>>) {
        value = p1.getOrDefault(emptyList())
    }
}