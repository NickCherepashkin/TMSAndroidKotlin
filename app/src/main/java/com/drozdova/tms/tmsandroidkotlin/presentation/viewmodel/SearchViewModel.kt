package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor
import com.drozdova.tms.tmsandroidkotlin.model.Item
import kotlinx.coroutines.launch
import javax.inject.Inject


class SearchViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) :ViewModel() {
    private val _item = MutableLiveData<Item>()
    val item: LiveData<Item> = _item

    fun findItem(searchText: String) {
        viewModelScope.launch {
            try {
                val foundItem = itemsInteractor.findItem(searchText)
                _item.value = foundItem
            } catch (e: Exception) {
                Log.w("exception", e.toString())
            }

        }
    }
}