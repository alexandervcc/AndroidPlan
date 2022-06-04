package com.example.testapp.activity

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.testapp.R
import com.example.testapp.databinding.ActivityServiceBinding
import com.example.testapp.servicios.ExampleService

class ServiceActivity : AppCompatActivity() {
    lateinit var binding: ActivityServiceBinding

    var servicio:ExampleService? = null

    lateinit var listaFrutas:ArrayList<String>
    lateinit var adapterListView:ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vincularServicio()

        listaFrutas = ArrayList()
        adapterListView = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaFrutas)

        binding.listViewFrutasService.adapter = adapterListView
        binding.buttonAddListData.setOnClickListener {
            recuperarDatosServicio()
        }
    }

    private fun vincularServicio(){
        bindService(
            Intent(this,ExampleService::class.java),
            conexionComponenteServicio,
            BIND_AUTO_CREATE
        )
    }

    private fun recuperarDatosServicio(){
        if(servicio!=null){
            var listaAuxiliar: List<String> = servicio!!.obtenerLista()
            listaFrutas.clear()
            listaFrutas.addAll(listaAuxiliar)

            //notificacion de cambios de datos
            adapterListView.notifyDataSetChanged()
        }
    }

    //COMPONENTE PARA LA CONEXION
    private val conexionComponenteServicio:ServiceConnection = object:ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            servicio = (p1 as ExampleService.CustomBinder).servicio
            Toast.makeText(this@ServiceActivity,"Servicio Vinculado",Toast.LENGTH_SHORT).show()
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            servicio = null
        }
    }

}