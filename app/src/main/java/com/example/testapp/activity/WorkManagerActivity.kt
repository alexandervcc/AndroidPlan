package com.example.testapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import com.example.testapp.databinding.ActivityWorkManagerBinding
import com.example.testapp.workers.Worker01
import com.example.testapp.workers.Worker02
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWorkManagerBinding

    private lateinit var mangerWorker: WorkManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Requests
        //Trabajo y tipo
        val work = OneTimeWorkRequestBuilder<Worker01>().build()
        val workP = PeriodicWorkRequestBuilder<Worker01>(5,TimeUnit.SECONDS).build()

        //Manager Obtencion
        mangerWorker = WorkManager.getInstance(this)
        //mangerWorker.enqueue(work)
        mangerWorker.enqueue(workP)
        //cancelar request
        if(!mangerWorker.getWorkInfoById(workP.id).isCancelled){
            mangerWorker.cancelAllWork()
        }

        //VERIFICAR QUE SE CUMPLAN CONDICIONES PARA LA EJECUCION DE UN WORK
        var restricciones = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
            .setRequiresBatteryNotLow(true)
            .build()

        val workUnico02 = OneTimeWorkRequestBuilder<Worker01>()
            .setConstraints(restricciones)//restricciones
            .build()
        mangerWorker.enqueue(workUnico02)

        //Acceso al estado del workInfo
        mangerWorker
            .getWorkInfoById(workUnico02.id)//Pasar el ID del workRequest
            .get()//obtener el WorkInfo
            .state
            //anadir observadores -> viewmodels

        //  ->|w|->|w|->|w|->
        //Paso de entrada de datos
        val inData = Data.Builder()
            .putString("k1","string01")
            .putInt("k2",123)
            .build()

        val workUnico03 = OneTimeWorkRequestBuilder<Worker01>()
            .setConstraints(restricciones)//restricciones
            .setInputData(inData)
            .build()

        mangerWorker.enqueue(workUnico03)

        //Cadena de trabajadores
        var cadena = mangerWorker.beginWith(workUnico03)

        val workerTipo2 =  OneTimeWorkRequestBuilder<Worker02>()
            .setConstraints(restricciones)//restricciones
            .build()

        cadena = cadena.then(workerTipo2)

        //ejecutar la cadena
        cadena.enqueue()

    }
}