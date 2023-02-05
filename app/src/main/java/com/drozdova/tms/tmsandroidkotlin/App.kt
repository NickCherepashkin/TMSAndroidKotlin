package com.drozdova.tms.tmsandroidkotlin

import android.app.Application
import android.util.Log
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.drozdova.tms.tmsandroidkotlin.data.workmanager.PeriodWorker
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class App : Application(), Configuration.Provider {

    @Inject lateinit var workFactory: HiltWorkerFactory

    private val appScope = CoroutineScope(Dispatchers.Default)

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workFactory)
            .setMinimumLoggingLevel(Log.DEBUG)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appScope.launch {
            createWorkManager()
        }
    }

    private fun createWorkManager() {
        val repeatingRequest = PeriodicWorkRequestBuilder<PeriodWorker>(15, TimeUnit.MINUTES)
            .setInitialDelay(15,TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            PeriodWorker.WORKER_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest
        )
    }
}