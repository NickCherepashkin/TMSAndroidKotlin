package com.drozdova.tms.tmsandroidkotlin.data.model

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("")
    val list: List<UserInfo>
)
