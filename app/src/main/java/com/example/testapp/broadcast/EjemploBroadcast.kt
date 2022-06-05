package com.example.testapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast

class EjemploBroadcast:BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0,"Accion enviada",Toast.LENGTH_SHORT).show()
        val vibrador = p0!!.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrador.vibrate(VibrationEffect.createOneShot(1000,VibrationEffect.DEFAULT_AMPLITUDE))
    }
}
