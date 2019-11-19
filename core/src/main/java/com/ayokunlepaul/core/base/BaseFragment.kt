package com.ayokunlepaul.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

abstract class BaseFragment <out VIEWMODEL> : DaggerFragment() {

    abstract val layoutId: Int

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(layoutId, container, false)
        return rootView
    }
}