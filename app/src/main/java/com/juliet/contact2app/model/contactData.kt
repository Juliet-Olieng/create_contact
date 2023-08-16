package com.juliet.contact2app.model
import CustomTypeAdapter
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.GsonBuilder

@Entity(tableName = "Contacts")
data class ContactData(
    @PrimaryKey(autoGenerate = true) var contactId: Int,
    var name: String,
    var emailAddress: String,
    var phoneNumber: String,
    var avatar: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(contactId)
        parcel.writeString(name)
        parcel.writeString(emailAddress)
        parcel.writeString(phoneNumber)
        parcel.writeString(avatar)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactData> {
        override fun createFromParcel(parcel: Parcel): ContactData {
            return ContactData(parcel)
        }

        override fun newArray(size: Int): Array<ContactData?> {
            return arrayOfNulls(size)
        }
    }
}

val gson: Gson = GsonBuilder()
    .registerTypeAdapter(ContactData::class.java, CustomTypeAdapter())
    .create()
