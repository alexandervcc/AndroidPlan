package com.example.testapp.rvadapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.model.Persona

class Holder(var v: View,context: Context):RecyclerView.ViewHolder(v),View.OnClickListener
{
    var context:Context
    var tvNombre:TextView
    var tvApellido:TextView
    var ivImage:ImageView
    lateinit var dataPasser:dataValuePass

    init {
        this.context=context
        tvNombre = v.findViewById(R.id.tvNombre)
        tvApellido = v.findViewById(R.id.tvApellido)
        ivImage = v.findViewById(R.id.rv_iv01)
        ivImage.setOnClickListener(this)
    }

//    fun binding(persona:Persona,position:Int){
//        tvNombre.text = persona.nombre
//        tvApellido.text = persona.apellido
//        if(position%2==0){
//            v.setBackgroundColor(ContextCompat.getColor(context,R.color.purple_200))
//        }else{
//            v.setBackgroundColor(ContextCompat.getColor(context,R.color.teal_200))
//        }
//    }

    fun binding(persona:Persona,tracker:SelectionTracker<Long>){
        tvNombre.text = persona.nombre
        tvApellido.text = persona.apellido

        if(tracker.isSelected(adapterPosition.toLong())){
            v.setBackgroundColor(ContextCompat.getColor(context,R.color.purple_200))
        }else{
            v.setBackgroundColor(ContextCompat.getColor(context,R.color.teal_200))
        }
    }

    override fun onClick(p0: View?) {
        //Toast.makeText(context,"Iv pressed",Toast.LENGTH_SHORT).show()
        var data = tvNombre.text.toString()
        dataPasser.passData(data)
    }

    fun passData(paramInterface:dataValuePass){
        this.dataPasser = paramInterface
    }

    fun getItemDetails():ItemDetailsLookup.ItemDetails<Long> =
        object: ItemDetailsLookup.ItemDetails<Long>(){
            override fun getPosition(): Int = adapterPosition
            override fun getSelectionKey(): Long? =itemId
        }

}