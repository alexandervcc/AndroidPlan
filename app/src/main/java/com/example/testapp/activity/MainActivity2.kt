package com.example.testapp.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.testapp.model.Persona
import com.example.testapp.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var txtView= findViewById<TextView>(R.id.textViewAc2)
        var extras = intent.extras
        if (extras != null){
            txtView.text = extras.getString("nombre")
            var persona: Persona? = extras.getParcelable("persona")
        }

        findViewById<Button>(R.id.buttonac2)
            .setOnClickListener {
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))
                    startActivity(intent)
             }
    }
}