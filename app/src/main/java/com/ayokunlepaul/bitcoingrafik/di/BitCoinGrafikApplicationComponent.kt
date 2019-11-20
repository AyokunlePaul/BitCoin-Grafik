package com.ayokunlepaul.bitcoingrafik.di

import com.ayokunlepaul.bitcoingrafik.BitCoinGrafikApplication
import com.ayokunlepaul.bitcoingrafik.di.modules.ActivityBindingModule
import com.ayokunlepaul.bitcoingrafik.di.modules.FragmentBindingModule
import com.ayokunlepaul.bitcoingrafik.di.modules.ViewModelBindingModule
import com.ayokunlepaul.core.di.BitCoinGrafikCoreComponent
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    dependencies = [
        BitCoinGrafikCoreComponent::class
    ],
    modules = [
        AndroidSupportInjectionModule::class, ViewModelBindingModule::class,
        FragmentBindingModule::class, ActivityBindingModule::class
    ]
)
interface BitCoinGrafikApplicationComponent : AndroidInjector<BitCoinGrafikApplication>