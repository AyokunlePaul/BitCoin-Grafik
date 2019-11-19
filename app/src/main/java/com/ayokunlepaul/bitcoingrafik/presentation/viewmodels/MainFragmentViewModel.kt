package com.ayokunlepaul.bitcoingrafik.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayokunlepaul.blockchaingraph.BlockchainGrafik
import com.ayokunlepaul.domain.models.BitCoinChartValue
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
    private val grafik: BlockchainGrafik
): ViewModel() {

    private val _blockchainValues = MutableLiveData<List<BitCoinChartValue>>()
    val blockchainValues: LiveData<List<BitCoinChartValue>>
        get() = _blockchainValues

    init {
        grafik.getBlockchainValuesRemote()
        grafik.getBlockchainValuesLocal {
            _blockchainValues.postValue(it.getOrNull())
        }
    }

    fun getBlockchainValues() {

    }

    override fun onCleared() {
        super.onCleared()
        grafik.cleanUp()
    }
}