package com.ayokunlepaul.core.base

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.ayokunlepaul.core.R
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment

abstract class BaseFragment <out VIEWMODEL> : DaggerFragment() {

    abstract val layoutId: Int

    protected lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(layoutId, container, false)
        return rootView
    }

    fun showSnackBar(
        rootView: View,
        text: String,
        isError: Boolean = false,
        duration: Int = Snackbar.LENGTH_SHORT
    ) {
        val snackBar = Snackbar.make(rootView, text, duration)

        if (snackBar.view.layoutParams is FrameLayout.LayoutParams) {
            val param = snackBar.view.layoutParams as FrameLayout.LayoutParams

            val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
            if (isError) snackBarLayout.setBackgroundColor(Color.RED) else snackBarLayout.setBackgroundColor(
                ContextCompat.getColor(requireContext(), R.color.colorPrimary)
            )
            snackBarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
                .setTextColor(ContextCompat.getColor(rootView.context, android.R.color.white))
            param.gravity = Gravity.TOP
            snackBar.view.layoutParams = param
        }

        snackBar.show()
    }

    protected fun navigate(direction: NavDirections) = findNavController().navigate(direction)

    protected fun navigateBack() = findNavController().navigateUp()
}