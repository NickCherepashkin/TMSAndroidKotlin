package com.drozdova.tms.tmsandroidkotlin.presentation.view.service

import android.app.Service
import android.content.Intent
import android.os.IBinder


class MusicService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }
}