package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val interactor: ItemsInteractor
) : ViewModel() {
    private val _itemsList = MutableLiveData<List<Item>>()
    val itemsList : LiveData<List<Item>> = _itemsList

    private val _bundle = MutableLiveData<Item?>()
    val bundle : LiveData<Item?> = _bundle

    private val _msg = MutableLiveData<String>()
    val msg : LiveData<String> = _msg


    fun getItemslist() {
        _itemsList.value = interactor.getItemslist()
    }

    fun itemDetailsClick(name: String, date: String, image: Int) {
        _bundle.value = Item(image, name, date)
    }

    fun onItemsBack() {
        _bundle.value = null
    }

    fun imageClick() {
        _msg.value = "messagesssssssss........"
    }
}