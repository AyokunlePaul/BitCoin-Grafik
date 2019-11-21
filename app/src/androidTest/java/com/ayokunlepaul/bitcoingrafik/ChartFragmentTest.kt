package com.ayokunlepaul.bitcoingrafik

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ayokunlepaul.bitcoingrafik.presentation.viewmodels.MainFragmentViewModel
import io.mockk.impl.annotations.MockK
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChartFragmentTest {

    @MockK
    lateinit var mainFragmentViewModel: MainFragmentViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()


}