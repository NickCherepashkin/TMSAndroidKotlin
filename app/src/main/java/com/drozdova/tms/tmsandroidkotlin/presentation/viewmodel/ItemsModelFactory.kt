package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor

class ItemsModelFactory(private val interactor: ItemsInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(interactor) as T
    }
}