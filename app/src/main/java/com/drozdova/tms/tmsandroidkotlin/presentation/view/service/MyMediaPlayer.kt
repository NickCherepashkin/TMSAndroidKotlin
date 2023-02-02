package com.drozdova.tms.tmsandroidkotlin.presentation.view.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.drozdova.tms.tmsandroidkotlin.R

class MyMediaPlayer: Service() {
    private lateinit var mediaPlayer: MediaPlayer


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.song)
    }

}