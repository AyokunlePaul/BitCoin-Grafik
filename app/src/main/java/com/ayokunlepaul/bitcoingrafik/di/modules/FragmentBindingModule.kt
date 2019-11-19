package com.ayokunlepaul.bitcoingrafik.di.modules

import com.ayokunlepaul.bitcoingrafik.presentation.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    @Singleton
    internal abstract fun bindMainFragment(): MainFragment
}