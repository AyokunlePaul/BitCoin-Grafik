package com.ayokunlepaul.bitcoingrafik.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.ayokunlepaul.bitcoingrafik.R
import com.ayokunlepaul.bitcoingrafik.presentation.viewmodels.MainFragmentViewModel
import com.ayokunlepaul.bitcoingrafik.utils.convert
import com.ayokunlepaul.bitcoingrafik.utils.toEntries
import com.ayokunlepaul.core.base.BaseFragment
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.fragment_main.*
import timber.log.Timber
import javax.inject.Inject

class MainFragment : BaseFragment<MainFragmentViewModel>() {

    @Inject lateinit var mainFragmentViewModel: MainFragmentViewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        mainFragmentViewModel.blockchainValues.observe(this, Observer {
            populateChart(it.convert { bitCoinChartValue ->
                bitCoinChartValue.toEntries()
            })
            Timber.e("$it")
        })
    }

    private fun populateChart(entries: List<Entry>) {
        val dataSet = LineDataSet(entries, "BitCoin Chart Value")
        dataSet.apply {
            color = ContextCompat.getColor(requireContext(), R.color.colorPrimary)
        }
        bitcoin_data_chart.apply {
            isLogEnabled = true
            description = Description().apply { text = "Average USD market price across major bitcoin exchanges." }
            data = LineData(dataSet)
            invalidate()
        }
    }
}