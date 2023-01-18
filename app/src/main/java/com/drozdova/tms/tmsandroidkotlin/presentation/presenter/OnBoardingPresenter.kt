package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.R

class OnBoardingPresenter (
) {
    private lateinit var onBoardingView: OnBoardingView

    fun setOnBoardingView(onBoardingView: OnBoardingView) {
        this.onBoardingView = onBoardingView
    }

    fun showItemsList() {
        onBoardingView.showList(R.id.action_onBoardingFragment_to_itemsListFragment)
    }
}