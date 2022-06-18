package com.practice.shoppingmvvm.WorkManager

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestShopingWorker(val context:Context, params :WorkerParameters ) : Worker(context,params) {
    override fun doWork(): Result {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("and____","Work Manager Call")
        }
        return Result.success()
    }
}