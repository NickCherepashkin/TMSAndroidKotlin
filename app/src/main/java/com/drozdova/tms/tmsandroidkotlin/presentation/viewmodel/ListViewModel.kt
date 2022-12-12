package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.data.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.ListInteractor

class ListViewModel(private val listInteractor: ListInteractor) : ViewModel() {
    private val _itemsList = MutableLiveData<List<Item>>()
    val itemsList : LiveData<List<Item>> = _itemsList

    private val _msg = MutableLiveData<String>()
    val msg : LiveData<String> = _msg

    fun getDataList() {
        _itemsList.value = listInteractor.getData()
    }

    fun getSelMessage() {

    }
}