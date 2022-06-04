package com.example.testapp.servicios

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*
import kotlin.collections.ArrayList

class ExampleService : Service() {
    var timer: Timer?=null
    var bindingService :IBinder = CustomBinder()
    lateinit var lista:ArrayList<String>
    var arregloDatos = arrayOf("manzana","pera","platano","pitahalla","maracuya")
    var index = 0

    override fun onCreate() {
        super.onCreate()
        index = 0
        timer = Timer()
        lista = ArrayList()
        iniciarCargaDeTrabajo()
    }

    //Carga de trabajo del SErvicios
    fun iniciarCargaDeTrabajo(){
        timer?.scheduleAtFixedRate(object:TimerTask(){
            override fun run() {
                if(lista.size>=15){
                    lista.removeFirst()
                }
                lista.add(arregloDatos[index%arregloDatos.size])
                index++
            }
        },0,5000)
    }

    //comunicacion con los copmonetnes
    fun obtenerLista():List<String >{
        return lista
    }

    //Binding:
    override fun onBind(intent: Intent): IBinder {
        return bindingService
    }


    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }

    //crear un clase para la referencia del servicio hacia el componente
    internal inner class CustomBinder:Binder(){
        val servicio:ExampleService
            get() = this@ExampleService
    }



    //    //Independiente de components
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        return super.onStartCommand(intent, flags, startId)
//    }

}