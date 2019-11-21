package com.ayokunlepaul.bitcoingrafik.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.ayokunlepaul.bitcoingrafik.BuildConfig
import com.ayokunlepaul.bitcoingrafik.R
import com.ayokunlepaul.bitcoingrafik.presentation.viewmodels.MainFragmentViewModel
import com.ayokunlepaul.bitcoingrafik.utils.convert
import com.ayokunlepaul.bitcoingrafik.utils.toEntries
import com.ayokunlepaul.core.base.BaseFragment
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.fragment_bitcoin_chart.*
import timber.log.Timber
import javax.inject.Inject

class BitCoinChartFragment : BaseFragment<MainFragmentViewModel>() {

    @Inject
    lateinit var mainFragmentViewModel: MainFragmentViewModel

    override val layoutId: Int
        get() = R.layout.fragment_bitcoin_chart

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        mainFragmentViewModel.bitCoinValues.observe(this, Observer {
            if (it == null) {
                query_state.apply {
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                    setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.faint_red))
                    text = mainFragmentViewModel.errorMessage
                    visibility = View.VISIBLE
                }
            } else {
                query_state.apply {
                    setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
                    setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.faint_green))
                    text = requireContext().getString(R.string.data_fetched)
                }
                populateChart(it.convert { bitCoinChartValue ->
                    bitCoinChartValue.toEntries()
                })
                Handler().postDelayed({
                    query_state.visibility = View.GONE
                }, 2000)
            }
            Timber.e("$it")
        })
        mainFragmentViewModel.getBitCoinValues()
    }

    private fun setupToolbar() {
        bitcoin_chart_toolbar.apply {
            setNavigationOnClickListener { navigateBack() }
            inflateMenu(R.menu.menu_refresh)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_refresh -> {
                        refresh()
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun refresh() {
        query_state.apply {
            setTextColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.faint_blue))
            text = requireContext().getString(R.string.fetching_data)
            visibility = View.VISIBLE
        }
        mainFragmentViewModel.getBitCoinValues()
    }

    private fun populateChart(entries: List<Entry>) {
        val dataSet = LineDataSet(entries, "BitCoin Chart Value")
        dataSet.apply {
            color = ContextCompat.getColor(requireContext(), R.color.colorPrimary)
        }
        bitcoin_data_chart.apply {
            animator
            isLogEnabled = BuildConfig.DEBUG
            description = Description().apply { text = "Average USD market price across major bitcoin exchanges." }
            data = LineData(dataSet)
            invalidate()
        }
    }
}