package com.example.testapp.rvadapter

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

class LookUp(var rv:RecyclerView):ItemDetailsLookup<Long>() {
    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        val view = rv.findChildViewUnder(e.x,e.y)
        if(view!=null){
            return (rv.getChildViewHolder(view) as Holder).getItemDetails()
        }
        return null;
    }
}