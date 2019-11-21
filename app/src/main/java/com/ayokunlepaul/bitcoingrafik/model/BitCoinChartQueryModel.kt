package com.ayokunlepaul.bitcoingrafik.model

data class BitCoinChartQueryModel (
    var statType: String? = null,
    var span: String? = null
) {

    fun newBitCoinChartValues(block: BitCoinChartQueryModel.() -> Unit) {
        this.apply(block)
    }
}