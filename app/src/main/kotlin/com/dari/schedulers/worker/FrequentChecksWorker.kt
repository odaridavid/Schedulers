package com.dari.schedulers.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class FrequentChecksWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        return Result.success()
    }

}