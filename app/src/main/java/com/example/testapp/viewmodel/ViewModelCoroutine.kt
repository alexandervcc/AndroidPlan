package com.example.testapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class ViewModelCoroutine:ViewModel() {
    private val _data = MutableLiveData<ArrayList<String>>()
    val data : LiveData<ArrayList<String>>
        get() = _data
    private val ejemploDatos = arrayOf("21","20","19","18","17","16","15","14","13","12","11")

    //viewModelScope
    fun obtenerData(){
        val r = Random(0)
        val arrayAuxiliar = ArrayList<String>()
        val datos = r.nextInt(10)
        viewModelScope.launch {
            for( data in 0..datos){
                arrayAuxiliar.add(ejemploDatos[r.nextInt(ejemploDatos.size-1)])
                delay(2000)
            }
            _data.value = arrayAuxiliar
        }
    }
}