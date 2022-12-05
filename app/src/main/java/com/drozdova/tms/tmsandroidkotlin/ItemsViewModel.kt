package com.drozdova.tms.tmsandroidkotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

class ItemsViewModel: ViewModel() {
    private val _items = MutableLiveData<List<ItemsModel>>()
    val items : LiveData<List<ItemsModel>> = _items

    private val _bundle = MutableLiveData<Navigation>()
    val bundle : LiveData<Navigation?> = _bundle

    fun getItems() {
        val listItems = listOf(
            ItemsModel(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.dot_net,
                ".Net",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.delphi,
                "Delphi",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.java,
                "Java",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.python,
                "Python",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.js,
                "Java Script",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            )
        )
        _items.value = listItems
    }

    fun onElementSelected(name: String, date: String, imageView: Int) {

    }

    fun userNavigated() {
        _bundle.value = null
    }
}

data class Navigation(
    val img: Int,
    val date: String,
    val name: String
)