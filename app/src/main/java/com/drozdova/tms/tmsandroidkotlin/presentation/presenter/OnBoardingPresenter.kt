package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.auth.OnBoardingInteractor
import javax.inject.Inject

class OnBoardingPresenter @Inject constructor(
    private val onBoardingInteractor: OnBoardingInteractor
){
    private lateinit var onBoardingView: OnBoardingView

    fun setOnBoardingView(onBoardingView: OnBoardingView) {
        this.onBoardingView = onBoardingView
    }

    fun showItemsList() {
        onBoardingView.showList(R.id.action_onBoardingFragment_to_itemsListFragment)
    }

    fun saveVisibility(doesVisible: Boolean) {
        onBoardingInteractor.saveVisibility(doesVisible)
    }
}