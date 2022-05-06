package com.example.testapp.rvadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.model.Persona

class AdapterRV(val personas:ArrayList<Persona>, val context: Context):
    RecyclerView.Adapter<Holder>(),View.OnClickListener
{
    lateinit var listener:View.OnClickListener
    lateinit var pasoCadena:dataValuePass
    lateinit var tracker:SelectionTracker<Long>

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): Holder
    {
        val item: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_layout,parent,false)
        item.setOnClickListener(this)
        var holder = Holder(item,context)

        //Configuracion para la interface
        holder.passData(object :dataValuePass{
            override fun passData(data: String) {
                pasoCadena.passData(data)
            }
        })

        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val itemUser = personas.get(position)
        holder.binding(itemUser,tracker)
    }

    override fun getItemCount(): Int {
        return personas.size
    }

    fun onClick(listener:View.OnClickListener){
        this.listener = listener
    }

    override fun onClick(p0: View?) {
        listener.onClick(p0)
    }

    fun passData(paramInterface:dataValuePass){
        this.pasoCadena = paramInterface
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}