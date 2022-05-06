package com.example.testapp.model

import android.os.Parcel
import android.os.Parcelable

class Persona(
    var nombre:String?,
    var apellido:String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        nombre = parcel.readString(),
        apellido = parcel.readString()
    ) {

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(nombre)
        p0.writeString(apellido)
    }

    //static
    companion object CREATOR : Parcelable.Creator<Persona> {
        override fun createFromParcel(parcel: Parcel): Persona {
            return Persona(parcel)
        }

        override fun newArray(size: Int): Array<Persona?> {
            return arrayOfNulls(size)
        }
    }
}