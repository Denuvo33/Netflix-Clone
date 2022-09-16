package com.example.videoplayer.Adapter

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable

data class MovieData(val movieImg : Int,val movieTitle: String,val movieRating:String,val movieDesc: String,val movieUrl:String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(movieImg)
        parcel.writeString(movieTitle)
        parcel.writeString(movieRating)
        parcel.writeString(movieDesc)
        parcel.writeString(movieUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieData> {
        override fun createFromParcel(parcel: Parcel): MovieData {
            return MovieData(parcel)
        }

        override fun newArray(size: Int): Array<MovieData?> {
            return arrayOfNulls(size)
        }
    }


}