package com.example.videoplayer.Adapter

import android.os.Parcel
import android.os.Parcelable

data class MovieData2(val img2: Int,val title2:String,val rating2:String,val desc2:String,val url: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(img2)
        parcel.writeString(title2)
        parcel.writeString(rating2)
        parcel.writeString(desc2)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieData2> {
        override fun createFromParcel(parcel: Parcel): MovieData2 {
            return MovieData2(parcel)
        }

        override fun newArray(size: Int): Array<MovieData2?> {
            return arrayOfNulls(size)
        }
    }
}