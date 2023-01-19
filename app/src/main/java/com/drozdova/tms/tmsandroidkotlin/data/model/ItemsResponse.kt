package com.drozdova.tms.tmsandroidkotlin.data.model

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("sample")
    val sampleList: List<Sample>
)
