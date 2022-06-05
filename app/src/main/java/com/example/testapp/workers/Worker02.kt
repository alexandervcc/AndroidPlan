package com.example.testapp.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class Worker02(val ctx: Context, params: WorkerParameters): Worker(ctx,params) {
    override fun doWork(): Result {
        //recuperacion
        val k1 = inputData.getString("k1")

        return try {
            //carga de trabajo real


            Result.success()
        }catch (throwable:Throwable){
            Result.failure()
        }
    }
}