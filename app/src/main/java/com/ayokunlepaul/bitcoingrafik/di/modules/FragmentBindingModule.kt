package com.ayokunlepaul.bitcoingrafik.di.modules

import com.ayokunlepaul.bitcoingrafik.presentation.fragments.BitCoinChartFragment
import com.ayokunlepaul.bitcoingrafik.presentation.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    internal abstract fun bindMainFragment(): MainFragment

    @ContributesAndroidInjector
    internal abstract fun bindBitCoinChartFragment(): BitCoinChartFragment
}