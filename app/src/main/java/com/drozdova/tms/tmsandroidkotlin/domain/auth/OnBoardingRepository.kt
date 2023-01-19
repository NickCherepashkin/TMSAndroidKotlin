package com.drozdova.tms.tmsandroidkotlin.domain.auth

interface OnBoardingRepository {
//    fun isVisible() : Boolean
    fun saveVisibility(doesVisible: Boolean)
}