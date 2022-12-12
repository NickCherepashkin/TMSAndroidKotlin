package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drozdova.tms.tmsandroidkotlin.domain.ListInteractor

class ListModelFactory(private val interactor: ListInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(interactor) as T
    }
}