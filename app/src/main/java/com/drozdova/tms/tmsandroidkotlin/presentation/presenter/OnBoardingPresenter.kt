package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

class OnBoardingPresenter (
) {
    private lateinit var onBoardingView: OnBoardingView

    fun setOnBoardingView(onBoardingView: OnBoardingView) {
        this.onBoardingView = onBoardingView
    }

    fun showItemsList() {
        onBoardingView.showList()
    }
}