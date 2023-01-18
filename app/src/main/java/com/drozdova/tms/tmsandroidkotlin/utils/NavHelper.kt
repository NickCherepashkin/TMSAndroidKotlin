package com.drozdova.tms.tmsandroidkotlin.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object NavHelper {
    fun Fragment.navigate(destination: Int) {
        findNavController().navigate(destination)
    }

    fun Fragment.navigateWithBundle(destination: Int, bundle: Bundle) {
        findNavController().navigate(destination, bundle)
    }

    fun Fragment.replaceGraph(graphId: Int) {
        findNavController().setGraph(graphId)
    }
}