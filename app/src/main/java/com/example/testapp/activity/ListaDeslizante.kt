package com.example.testapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.testapp.adapters.FragPageManager
import com.example.testapp.R

class ListaDeslizante : AppCompatActivity() {
    private lateinit var vistaDeslizante:ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_deslizante)

        vistaDeslizante = findViewById<ViewPager2>(R.id.vp01)
        var adapter = FragPageManager(this)
        vistaDeslizante.adapter = adapter
    }

    override fun onBackPressed() {
        if(vistaDeslizante.currentItem==0)
        {
            super.onBackPressed()
        }else{
            vistaDeslizante.currentItem = vistaDeslizante.currentItem-1
        }
    }

}