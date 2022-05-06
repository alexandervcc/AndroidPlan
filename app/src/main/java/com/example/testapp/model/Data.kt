package com.example.testapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Data: ViewModel() {
    private val data=MutableLiveData<String>()
    val getItem:LiveData<String> get() = data
    fun setItem(dataPar:String) {
        data.value = dataPar
    }
}