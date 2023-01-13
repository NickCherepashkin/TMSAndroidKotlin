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


    fun getItemslist() {
        viewModelScope.launch {
            _itemsList.value = interactor.getItemslist()
        }
    }

    fun itemDetailsClick(name: String, date: String, image: Int) {
        _bundle.value = ItemList(image, name, date, R.id.action_itemsFragment_to_detailsFragment)
    }

    fun onItemsBack() {
        _bundle.value = null
    }

    fun imageClick() {
        _msg.value = "messagesssssssss........"
    }
}

data class ItemList(
    val image: Int,
    val title: String,
    val date: String,
    val destination: Int
)
