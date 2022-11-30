package com.drozdova.tms.tmsandroidkotlin.listener

interface ItemListener {
    fun onClick()

    fun onElementSelected(name: String, date:String, imageView: Int)
}