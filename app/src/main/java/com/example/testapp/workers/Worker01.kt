package com.example.testapp.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class Worker01(val ctx: Context,params:WorkerParameters): Worker(ctx,params) {
    override fun doWork(): Result {
        //recuperacion
        val k1 = inputData.getString("k1")
        val k2 = inputData.getInt("k2",5)

        return try {
            //carga de trabajo real
            for (i in 0..k2){
                Thread.sleep(5000)
            }

            var output = workDataOf("k1" to "10")

            Result.success(output)
        }catch (throwable:Throwable){
            Result.failure()
        }
    }
}