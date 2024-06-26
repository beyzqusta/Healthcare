package com.example.healtcare1

import android.os.Parcel
import android.os.Parcelable

data class DtaClass( var dataImage:Int, var dataTitle:String, var dataDesc: String, var dataDetailImage: Int): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImage)
        parcel.writeString(dataTitle)
        parcel.writeString(dataDesc)
        parcel.writeInt(dataDetailImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DtaClass> {
        override fun createFromParcel(parcel: Parcel): DtaClass {
            return DtaClass(parcel)
        }

        override fun newArray(size: Int): Array<DtaClass?> {
            return arrayOfNulls(size)
        }
    }


}

