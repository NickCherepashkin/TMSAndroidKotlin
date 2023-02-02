package com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor
import com.drozdova.tms.tmsandroidkotlin.model.FavouriteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor
): ViewModel() {
    private val _fav = MutableLiveData<List<FavouriteModel>>()
    val fav: LiveData<List<FavouriteModel>> = _fav

    fun getFav() {
        viewModelScope.launch {
            try {
                val favList = itemsInteractor.getFav()
                _fav.value = favList
            } catch (e: java.lang.Exception) {
                Log.w("Fav error", e.toString())
            }
        }
    }
}