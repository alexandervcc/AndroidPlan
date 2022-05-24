package com.example.testapp.activity

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import com.example.testapp.R

class MenuActivity : AppCompatActivity() {
    private  lateinit var tvMenuChange:TextView
    private lateinit var ivMenu01:ImageView
    private lateinit var ivMenu02:ImageView
    private lateinit var ivMenuPopUp:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        tvMenuChange = findViewById<TextView>(R.id.tvMenuChange)
        ivMenu01 = findViewById(R.id.ivMenu01)
        ivMenu02 = findViewById(R.id.ivMenu02)
        ivMenuPopUp = findViewById(R.id.ivMenuPopUp)

        ivMenuPopUp.setOnClickListener {
            showMenuPopUp()
        }

        //registrar los elementos que desplegueran el context menu
        registerForContextMenu(ivMenu01)
        registerForContextMenu(ivMenu02)

    }




    //POPUP MENU
    private fun showMenuPopUp(){
        val menupop = PopupMenu(this,ivMenuPopUp)
        menupop.inflate(R.menu.menu_pop_up)

        menupop.setOnMenuItemClickListener {
            var contenido = ""
            when(it.itemId){
                R.id.menup_it01 -> contenido = "Pop01"
                R.id.menup_it02 -> contenido = "Pop02"
                R.id.menup_it03 -> contenido = "Pop03"
                else -> contenido = "Defecto"
            }
            Toast.makeText(this,"ItemPopSelected: ${contenido}",Toast.LENGTH_SHORT).show()
            true
        }

        //mostrarlo en pantalla
        menupop.show()
    }

    //CONTEXTUAL MENU
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        when(v!!.id){
            ivMenu01.id -> menuInflater.inflate(R.menu.menu01,menu)
            ivMenu02.id -> menuInflater.inflate(R.menu.menu02,menu)
        }
    }

    //funcion, maneja las opciones sobre todos los context menu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        var contenidoContext = ""
        when(item.itemId){
            R.id.menu01_it01 -> contenidoContext = "Context01-01"
            R.id.menu01_it02 -> contenidoContext = "Context01-02"
            R.id.menu01_it03 -> contenidoContext = "Context01-03"
            R.id.menu01_it04 -> contenidoContext = "Context01-04"

            R.id.menu02_it01 -> contenidoContext = "Context02-01"
            R.id.menu02_it02 -> contenidoContext = "Context02-02"
            else-> super.onContextItemSelected(item)

        }
        Toast.makeText(this,"Menu Item Selected: ${contenidoContext}",Toast.LENGTH_SHORT).show()
        return true
    }

    //OVERFLOW MENU
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //return super.onCreateOptionsMenu(menu)
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu01,menu)
        return true
    }

    //Actuar sobre la seleccion de algun menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var contenido = ""
        when(item.itemId){
            R.id.menu01_it01->contenido="menu01"
            R.id.menu01_it02->contenido="menu02"
            R.id.menu01_it03->contenido="menu03"
            R.id.menu01_it04->contenido="menu04"
            else -> super.onOptionsItemSelected(item)
        }
        tvMenuChange.text = contenido
        return true
    }

}