package com.ayokunlepaul.bitcoingrafik.utils

object BitCoinChartUtils {

    private val transactionTypes = listOf(
        Pair("Transactions Per Second", "n-transactions"),
        Pair("Market Price (USD)", "market-price"),
        Pair("Average Block Size", "avg-block-size"),
        Pair("Mempool Size", "mempool-size")
    )

    private val spans = listOf(
        Pair("30 days", "30days"),
        Pair("60 days", "60days"),
        Pair("180 days", "180days"),
        Pair("All Time", "all")
    )

    fun getStatType(): List<String> {
        return transactionTypes.map { it.first }
    }

    fun getStatQueryId(position: Int): String {
        return transactionTypes[position].second
    }

    fun getTimeSpans(): List<String> {
        return spans.map { it.first }
    }

    fun getTimeSpanQueryId(position: Int): String {
        return spans[position].second
    }
}