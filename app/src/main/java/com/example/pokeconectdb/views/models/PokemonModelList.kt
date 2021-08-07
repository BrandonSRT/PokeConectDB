package com.example.pokeconectdb.views.models

import android.os.Parcel
import android.os.Parcelable

class PokemonModelList(val name:String, val imageUrl:String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonModelList> {
        override fun createFromParcel(parcel: Parcel): PokemonModelList {
            return PokemonModelList(parcel)
        }

        override fun newArray(size: Int): Array<PokemonModelList?> {
            return arrayOfNulls(size)
        }
    }
}