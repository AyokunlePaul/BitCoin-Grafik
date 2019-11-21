package com.ayokunlepaul.bitcoingrafik.di.modules

import com.ayokunlepaul.bitcoingrafik.presentation.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBindingModule {

    @Singleton
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}