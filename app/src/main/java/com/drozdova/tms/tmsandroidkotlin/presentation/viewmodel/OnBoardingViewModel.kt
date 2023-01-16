package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.onboarding.OnBoardingInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onBoardingInteractor: OnBoardingInteractor
): ViewModel() {
    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun showList() {
        _nav.value = R.id.action_onBoardingFragment_to_itemsListFragment
    }

    fun setVisibility(visibility: Boolean) {
        onBoardingInteractor.saveVisibility(visibility)
    }

    fun onBoardingBack() {
        _nav.value = null
    }
}