package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.drozdova.tms.tmsandroidkotlin.R

object Navigation {
    fun setFragment(parentFragmentManager: FragmentManager, fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragments_container, fragment)
            .addToBackStack("sss")
            .commit()

    }
}