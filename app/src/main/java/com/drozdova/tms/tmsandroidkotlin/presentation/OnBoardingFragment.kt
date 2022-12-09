package com.drozdova.tms.tmsandroidkotlin.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {
    private var _viewBinding : FragmentOnBoardingBinding? = null
    val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        bundle?.let { logBundle ->
            viewBinding.materialTextView2.text = "${logBundle.getString("login")} is on Boarding fragment"
        }

    }

}