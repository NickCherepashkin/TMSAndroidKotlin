package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsListInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsListViewModel @Inject constructor(
    private val listInteractor: ItemsListInteractor
): ViewModel() {
    private val _itemsList = MutableLiveData<List<Item>>()
    val itemsList: LiveData<List<Item>> = _itemsList

    private val _bundle = MutableLiveData<Item?>()
    val bundle : LiveData<Item?> = _bundle

    private val _msg = MutableLiveData<String>()
    val msg : LiveData<String> = _msg

    fun getData() {
        _itemsList.value = listInteractor.getData()
    }

    fun goToDetails(name: String, date: String, imageView: Int) {
        _bundle.value = Item(imageView, name, "", date)
    }

    fun onItemsBack() {
        _bundle.value = null
    }

    fun imageClick(message: String) {
        _msg.value = message
    }
}