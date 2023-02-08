package com.drozdova.tms.tmsandroidkotlin.presentation.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val favorite: Boolean
)
