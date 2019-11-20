package com.ayokunlepaul.bitcoingrafik.di.modules

import androidx.lifecycle.ViewModel
import com.ayokunlepaul.bitcoingrafik.presentation.viewmodels.MainFragmentViewModel
import com.ayokunlepaul.core.di.keys.BitCoinGrafikViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelBindingModule {

    @Binds
    @IntoMap
    @Singleton
    @BitCoinGrafikViewModelKey(MainFragmentViewModel::class)
    internal abstract fun bindMainFragmentViewModel(
        viewModel: MainFragmentViewModel
    ): ViewModel
}