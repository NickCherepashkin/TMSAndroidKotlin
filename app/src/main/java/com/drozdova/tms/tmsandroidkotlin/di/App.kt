package com.drozdova.tms.tmsandroidkotlin.di

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.drozdova.tms.tmsandroidkotlin.data.worker.PeriodWorker
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class App : Application(), Configuration.Provider {

    @Inject lateinit var workerFactory: HiltWorkerFactory

    val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .build()

        override fun onCreate() {
            super.onCreate()
            applicationScope.launch {
                setupRecurringWork()
            }
        }

        private fun setupRecurringWork() {
            val repeating = PeriodicWorkRequestBuilder<PeriodWorker>(15, TimeUnit.MINUTES).build()
            WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
                PeriodWorker.WORKER_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                repeating
            )
        }
}