package com.ayokunlepaul.bitcoingrafik.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayokunlepaul.blockchaingraph.BlockchainGrafik
import com.ayokunlepaul.domain.models.BitCoinChartValue
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
    private val grafik: BlockchainGrafik
) : ViewModel() {

    private val _bitCoinValues = MutableLiveData<List<BitCoinChartValue>>()
    val bitCoinValues: LiveData<List<BitCoinChartValue>>
        get() = _bitCoinValues

    lateinit var errorMessage: String

    init {
        getBitCoinValues()
    }

    fun getBitCoinValues() {
        grafik.getBitCoinValuesRemote {
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