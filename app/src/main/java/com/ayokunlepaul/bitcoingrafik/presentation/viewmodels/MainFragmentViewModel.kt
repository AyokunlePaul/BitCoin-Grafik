package com.ayokunlepaul.bitcoingrafik.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayokunlepaul.bitcoingrafik.model.BitCoinChartQueryModel
import com.ayokunlepaul.blockchaingraph.BlockchainGrafik
import com.ayokunlepaul.domain.models.BitCoinChartValue
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainFragmentViewModel @Inject constructor(
    private val grafik: BlockchainGrafik
) : ViewModel() {

    private val _bitCoinValues = MutableLiveData<List<BitCoinChartValue>>()
    val bitCoinValues: LiveData<List<BitCoinChartValue>>
        get() = _bitCoinValues

    lateinit var errorMessage: String

    private val bitCoinChartQueryModel by lazy { BitCoinChartQueryModel() }

    fun setStatType(
        type: String? = null,
        span: String? = null
    ) {
        bitCoinChartQueryModel.newBitCoinChartValues {
            statType = type ?: this.statType
            this.span = span ?: this.span
        }
    }

    fun getBitCoinValues() {
        grafik.getBitCoinValuesRemote (
            bitCoinChartQueryModel.statType!!,
            bitCoinChartQueryModel.span!!
        ) {
            if (it.isSuccess) {
                _bitCoinValues.postValue(it.getOrDefault(emptyList()))
            } else {
                it.exceptionOrNull()?.let { exception -> errorMessage = exception.localizedMessage!! }
                _bitCoinValues.postValue(null)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        grafik.cleanUp()
    }
}