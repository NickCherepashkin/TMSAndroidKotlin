package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsListInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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

    private val _msgError = MutableLiveData<String>()
    val msgError : LiveData<String> = _msgError

    fun getData() {
        viewModelScope.launch {
            try {
                _itemsList.value = listInteractor.getData()
            } catch (e: Exception) {
                _msgError.value = ErrorMessages.ERROR_MSG_NO_DATA
            }
        }
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