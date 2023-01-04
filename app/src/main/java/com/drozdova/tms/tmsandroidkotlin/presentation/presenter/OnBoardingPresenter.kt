package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.OnBoardingFragment
import javax.inject.Inject

class OnBoardingPresenter @Inject constructor() {

    private lateinit var onBoardingView: OnBoardingView

    fun setOnBoardingView(onBoardingFragment: OnBoardingFragment) {
        onBoardingView = onBoardingFragment
    }
    fun goToItemsFragment() {
        onBoardingView.goToItemsFragment()
    }
}