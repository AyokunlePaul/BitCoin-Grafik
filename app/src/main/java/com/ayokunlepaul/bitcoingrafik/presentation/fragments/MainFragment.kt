package com.ayokunlepaul.bitcoingrafik.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.ayokunlepaul.bitcoingrafik.R
import com.ayokunlepaul.bitcoingrafik.presentation.viewmodels.MainFragmentViewModel
import com.ayokunlepaul.bitcoingrafik.utils.BitCoinChartUtils
import com.ayokunlepaul.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : BaseFragment<MainFragmentViewModel>() {

    @Inject lateinit var mainFragmentViewModel: MainFragmentViewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDropDownMenus()
        get_bitcoin_graph.setOnClickListener {
            when {
                statistics_auto_complete.text.isEmpty() -> {
                    showSnackBar(rootView, "Please select stat type", true)
                    return@setOnClickListener
                }
                time_span_auto_complete.text.isEmpty() -> {
                    showSnackBar(rootView, "Please select time span", true)
                    return@setOnClickListener
                }
            }
            val direction = MainFragmentDirections.actionFragmentMainToFragmentBitcoinChart()
            navigate(direction)
        }
    }

    private fun setupDropDownMenus() {
        statistics_auto_complete.apply {
            setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, BitCoinChartUtils.getStatType()))
            setOnItemClickListener { _, _, position, _ ->
                mainFragmentViewModel.setStatType(type = BitCoinChartUtils.getStatQueryId(position))
            }
        }
        time_span_auto_complete.apply {
            setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, BitCoinChartUtils.getTimeSpans()))
            setOnItemClickListener { _, _, position, _ ->
                mainFragmentViewModel.setStatType(span = BitCoinChartUtils.getTimeSpanQueryId(position))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setupDropDownMenus()
    }
}