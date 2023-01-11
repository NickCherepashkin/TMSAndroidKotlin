package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.domain.onboarding.OnBoardingInteractor
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
        viewModelScope.launch {
            try {
                launch {
                    onBoardingInteractor.saveVisibility(visibility)
                }
            } catch (e: Exception) {
                Log.w(ErrorMessages.WARNING, "${ErrorMessages.ERROR_MSG_SAVE_VISIBILITY} $e")
            }
        }

    }
}