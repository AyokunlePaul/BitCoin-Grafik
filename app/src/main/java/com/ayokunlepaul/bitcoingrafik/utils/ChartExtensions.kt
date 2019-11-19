package com.ayokunlepaul.bitcoingrafik.utils

import com.ayokunlepaul.domain.models.BitCoinChartValue
import com.github.mikephil.charting.data.Entry

fun BitCoinChartValue.toEntries(): Entry {
    return Entry(xAxis.toFloat(), yAxis.toFloat())
}

fun <F, T> List<F>.convert(converter: (F) -> T): List<T> {
    return map {
        converter.invoke(it)
    }
}