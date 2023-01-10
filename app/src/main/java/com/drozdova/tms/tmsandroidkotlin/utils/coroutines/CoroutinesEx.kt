package com.drozdova.tms.tmsandroidkotlin.utils.coroutines

import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesEx {
    fun testCoroutineJoin() {
        CoroutineScope(Dispatchers.IO).launch {
            val job = launch {
                for(i in 1..5) {
                    Log.w("called", "$i")
                    delay(400)
                }
            }
            Log.w("start", "started")
            job.join()
            Log.w("finish", "finished")
        }
    }

    fun testCoroutineCancel() {
        CoroutineScope(Dispatchers.IO).launch {
            val job = launch {
                for(i in 1..5) {
                    Log.w("called", "$i")
                    delay(400)
                }
            }
            Log.w("start", "started")
            job.cancel()
            Log.w("finish", "finished")
        }
    }
}