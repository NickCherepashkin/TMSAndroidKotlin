package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val interactor: ItemsInteractor
) : ViewModel() {
    private val _itemsList = MutableLiveData<List<Item>>()
    val itemsList : LiveData<List<Item>> = _itemsList

    private val _bundle = MutableLiveData<ItemList?>()
    val bundle : LiveData<ItemList?> = _bundle

    private val _msg = MutableLiveData<String>()
    val msg : LiveData<String> = _msg

    private val _error = MutableLiveData<String?>()
    val error : LiveData<String?> = _error

    fun getItemslist() {
        viewModelScope.launch {
            try {
                interactor.getData()
                val list = interactor.showData()
                _itemsList.value = list

            } catch (e: java.lang.Exception) {
                _error.value = e.message.toString()
            }

        }
    }

    fun itemDetailsClick(description: String, image: String) {
        _bundle.value = ItemList(description, image, R.id.action_itemsFragment_to_detailsFragment)
    }

    fun onItemsBack() {
        _bundle.value = null
    }

    fun imageClick() {
        _msg.value = "messagesssssssss........"
    }

    fun deleteItem(description: String) {
        viewModelScope.launch {
            interactor.deleteItemByDescription(description)
        }

    }
}

data class ItemList(
    val description: String,
    val image: String,
    val destination: Int
)
