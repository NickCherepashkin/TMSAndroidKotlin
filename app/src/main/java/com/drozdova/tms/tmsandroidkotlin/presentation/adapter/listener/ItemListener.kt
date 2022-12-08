package com.drozdova.tms.tmsandroidkotlin.presentation.adapter.listener

interface ItemListener {
    fun onClick()

    fun onElementSelected(name: String, date:String, imageView: Int)
}