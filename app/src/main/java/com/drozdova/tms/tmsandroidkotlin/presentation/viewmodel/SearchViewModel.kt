package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor
import com.drozdova.tms.tmsandroidkotlin.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) :ViewModel() {
    private val _item = MutableLiveData<Item>()
    val item: LiveData<Item> = _item

    fun findItem(searchText: String) {
        viewModelScope.launch {
            val foundItem = itemsInteractor.findItem(searchText)
            _item.value = foundItem
        }
    }
}