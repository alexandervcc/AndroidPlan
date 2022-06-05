package com.example.testapp.activity

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.broadcast.EjemploBroadcast
import com.example.testapp.databinding.ActivityBroadcastBinding

class BroadcastActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBroadcastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadcastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBroadcast.setOnClickListener {
            activarBroadcast()
        }
    }

    private fun activarBroadcast() {
        val intent = Intent(this,EjemploBroadcast::class.java)
        val pIntent = PendingIntent.getBroadcast(this,1234,intent,PendingIntent.FLAG_MUTABLE)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, 10000,pIntent)
    }

}