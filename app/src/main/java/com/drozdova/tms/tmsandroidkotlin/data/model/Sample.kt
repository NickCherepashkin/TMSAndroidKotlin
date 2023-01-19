package com.drozdova.tms.tmsandroidkotlin.data.model

import com.google.gson.annotations.SerializedName

data class Sample(
    @SerializedName("description")
    val description: String,
    @SerializedName("image-url")
    val imageUrl: String
)
