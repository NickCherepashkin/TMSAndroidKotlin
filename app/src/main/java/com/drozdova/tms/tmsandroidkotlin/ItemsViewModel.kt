package com.drozdova.tms.tmsandroidkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.model.ItemModel
import java.text.SimpleDateFormat
import java.util.*

class ItemsViewModel : ViewModel() {
    private val _items = MutableLiveData<List<ItemModel>>()
    val items : LiveData<List<ItemModel>> = _items

    private val _bundle = MutableLiveData<ItemModel>()
    val bundle: LiveData<ItemModel> = _bundle

    fun getData() {
        val time = SimpleDateFormat("hh:mm:ss a").format(Date())
        val itemsList = mutableListOf(
            ItemModel(
                R.drawable.break_dance,
                "Breal Dance",
                "sssssss",
                time),
            ItemModel(
                R.drawable.hh,
                "Hip-hop",
                "sssssss",
                time),
            ItemModel(
                R.drawable.house,
                "House",
                "sssssss",
                time),
            ItemModel(
                R.drawable.belly,
                "Belly dance",
                "sssssss",
                time),
            ItemModel(
                R.drawable.locking,
                "Locking",
                "sssssss",
                time),
            ItemModel(
                R.drawable.krump,
                "Krump",
                "sssssss",
                time),
            ItemModel(
                R.drawable.contemp,
                "Contemporary",
                "sssssss",
                time)
        )

        _items.value = itemsList
    }

    fun itemClicked(image: Int, title: String, descript: String, time: String) {
        _bundle.value = ItemModel(image, title, descript, time)
    }
}