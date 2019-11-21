package com.ayokunlepaul.bitcoingrafik.presentation.activities

import android.os.Bundle
import com.ayokunlepaul.bitcoingrafik.R
import com.ayokunlepaul.bitcoingrafik.presentation.viewmodels.MainFragmentViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: MainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}