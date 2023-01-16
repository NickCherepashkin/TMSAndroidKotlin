package com.drozdova.tms.tmsandroidkotlin.domain.onboarding

import android.opengl.Visibility

interface OnBoardingRepository {
    suspend fun isVisible() : Boolean
    fun saveVisibility(visibility: Boolean)
}