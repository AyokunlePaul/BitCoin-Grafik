package com.ayokunlepaul.core.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule constructor(
    private val context: Context
) {

    @Provides
    internal fun provideContext() = context
}