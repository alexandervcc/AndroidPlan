package com.example.testapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.testapp.model.Persona
import com.example.testapp.R

class MainActivity : AppCompatActivity() {
    //Parte del ciclo de vida
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var contador:Int = 10
        var name:String = "xd"
        var persona = Persona("alex","charco")
        var str1:String = getString(R.string.activity1_name)

        //Referencia a un recurso grafico de la actividad
        findViewById<Button>(R.id.btn_Intent_Explicito)
            .setOnClickListener {
                var intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("contador", contador)
                intent.putExtra("nombre", name)
                intent.putExtra("persona", persona)
                startActivity(intent)
             }

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Actividad 1 en Destroy", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"Actividad 1 en Restart", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"Actividad 1 en Pausa", Toast.LENGTH_SHORT).show()
    }
}
