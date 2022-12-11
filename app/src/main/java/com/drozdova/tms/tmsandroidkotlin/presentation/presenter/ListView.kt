package com.drozdova.tms.tmsandroidkotlin.presentation.presenter

import com.drozdova.tms.tmsandroidkotlin.data.model.Item

interface ListView {
    fun setData(list: List<Item>)
}