package com.drozdova.tms.tmsandroidkotlin.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.drozdova.tms.tmsandroidkotlin.R

object NavHelper {
    fun Fragment.navigate(destinationId: Int) {
        findNavController().navigate(destinationId)
    }

    fun Fragment.navigateWithBundle(destinationId: Int, bundle: Bundle) {
        findNavController().navigate(destinationId, bundle)
    }

    fun Fragment.replaceGraph(graphId: Int) {
        findNavController().setGraph(graphId)
    }

    fun Fragment.navigateWithDeletedBackStack(destinationId: Int, fragmentTRemovw: Int) {
        val navOptions = NavOptions.Builder()
        navOptions.setPopUpTo(fragmentTRemovw, true)
        findNavController().navigate(
            destinationId,
            null, navOptions.build())
    }
}