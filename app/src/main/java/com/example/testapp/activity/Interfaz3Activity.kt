package com.example.testapp.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.model.Persona
import com.example.testapp.rvadapter.AdapterRV
import com.example.testapp.rvadapter.LookUp
import com.example.testapp.rvadapter.dataValuePass

class Interfaz3Activity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var rv:RecyclerView
    private var frutas = arrayOf("manzaza","banana","pera")
    lateinit var tracker:SelectionTracker<Long>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_interfaz3)
        //recuperar referencias
        spinner = findViewById(R.id.spinner01)
        rv = findViewById(R.id.rv01)

        //crear adaptador
        //val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_list_item_1, frutas)
        val adapterSpinner = ArrayAdapter.createFromResource(
            this, R.array.frutas2, android.R.layout.simple_list_item_1)

        spinner.adapter = adapterSpinner

        spinner.setOnItemClickListener(object:AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Log.d("adapters","Element selected: ${frutas[p2]}")
            }
        })

        //RECYCLE VIEW
        // adapter-> clase, viewholder, layoutManager->desplegar el tipo de vista
        val personas = ArrayList<Persona>()
        for( i in 0..30){
            personas.add(Persona("Nom: ${i}", "Ape: ${i}"))
        }
        val adapterRV = AdapterRV(personas,this)
        rv.adapter = adapterRV
        rv.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv.layoutManager =
            GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        //Grilla o tabla

        //Tracker
        tracker = SelectionTracker.Builder<Long>(
                "idSeleccion",
                rv,
                StableIdKeyProvider(rv),
                LookUp(rv),
                StorageStrategy.createLongStorage()
            ).withSelectionPredicate(
                SelectionPredicates.createSelectAnything()
            ).build()
        adapterRV.tracker = tracker

        //OnClick
        adapterRV.onClick(View.OnClickListener { v->
            Toast.makeText(this,
                "Selected: ${rv.getChildAdapterPosition(v)}",
                Toast.LENGTH_SHORT
            ).show()
        })

        //Configurar la interface hacia el adaptador
        adapterRV.passData(object:dataValuePass{
            override fun passData(data: String) {
                Toast.makeText(applicationContext,"Value: ${data}",Toast.LENGTH_SHORT).show()
            }
        })

        if(savedInstanceState!=null){
            tracker.onRestoreInstanceState(savedInstanceState)
        }

        //Obtener elementos del tracker
        tracker.addObserver(object: SelectionTracker.SelectionObserver<Long>() {
            override fun onSelectionChanged() {
                var cadena:String = ""
                if(tracker.hasSelection()){
                    tracker.selection.forEach { id ->
                        cadena += id.toString()+", "
                    }
                    Toast.makeText(applicationContext,"Selected: ${cadena}",Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(outState!=null){
            tracker.onSaveInstanceState(outState)
        }
    }
}