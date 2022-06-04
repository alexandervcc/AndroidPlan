package com.example.testapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.testapp.R
import com.example.testapp.viewmodel.ViewModelCoroutine
import kotlinx.coroutines.*

class CoroutinesActivity : AppCompatActivity() {
    var cScope = CoroutineScope(Dispatchers.Main)

     val viewModel:ViewModelCoroutine by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        //Corutina a nivel Global
        GlobalScope.launch{
            delay(5000)
            Toast.makeText(this@CoroutinesActivity,"Inside coruotine",Toast.LENGTH_SHORT).show()
        }

        cScope.launch {
            while(isActive){
                delay(5000)
                Toast.makeText(
                    this@CoroutinesActivity,
                    "Thread: ${Thread.currentThread().id}",Toast.LENGTH_SHORT
                ).show()
            }
        }
        viewModel.obtenerData()
    }

    fun ejemploCorutinaRunBlocking(){
        //runBlocking
        runBlocking(Dispatchers.IO) {
            for(i in 1..5){
                launch {
                    Toast.makeText(
                        this@CoroutinesActivity,
                        "Thread: ${Thread.currentThread().id}",Toast.LENGTH_SHORT
                    ).show()
                    delay(5000)
                }
            }
        }
        Toast.makeText(
            this@CoroutinesActivity,
            "Trabajos finalizados desde 'runBlocking'",Toast.LENGTH_SHORT
        ).show()
    }

    fun ejemploCorutinaLaunch(){
        CoroutineScope(Dispatchers.Main).launch{
            launch(Dispatchers.IO){

            }
        }
    }

    fun ejemploCorutinaAsync(){
        //funciones sin suspension
        var ejemplo:String? = null
        CoroutineScope(Dispatchers.Main).launch {
            var jobAsync = async{
                for(i in 1..5){
                    ejemplo = i.toString()
                    withContext(Dispatchers.IO){
                        delay(5000)
                    }
                }
                "Terminado"
            }
            var resultado = jobAsync.await()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cScope.cancel()
    }
}

