package com.dicoding.naufal.mybroadcastreceiver.service

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log
import androidx.core.app.JobIntentService
import androidx.core.app.JobIntentService.enqueueWork
import com.dicoding.naufal.mybroadcastreceiver.MainActivity

class DownloadService : JobIntentService() {

    companion object{
        val TAG: String = DownloadService::class.java.simpleName
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null){
            enqueueWork(this, this::class.java, 101, intent)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleWork(intent: Intent) {
        Log.d(TAG, "Download Service dijalankan")
        try {
            Thread.sleep(5000)
        }catch (e: InterruptedException){
            e.printStackTrace()
        }

        val notifyFinishIntent = Intent(MainActivity.ACTION_DOWNLOAD_STATUS)
        sendBroadcast(notifyFinishIntent)
    }
}