package com.drozdova.tms.tmsandroidkotlin.domain.onboarding

import android.opengl.Visibility

interface OnBoardingRepository {
    fun isVisible() : Boolean
    fun saveVisibility(visibility: Boolean)
}