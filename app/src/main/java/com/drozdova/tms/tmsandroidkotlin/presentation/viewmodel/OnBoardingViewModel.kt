package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.opengl.Visibility
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.domain.onboarding.OnBoardingInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onBoardingInteractor: OnBoardingInteractor
): ViewModel() {
    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun showList() {
        _nav.value = Unit
    }

    fun setVisibility(visibility: Boolean) {
        onBoardingInteractor.saveVisibility(visibility)
    }
}