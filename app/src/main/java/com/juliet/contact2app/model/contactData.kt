package com.juliet.contact2app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class ContactData(
    @PrimaryKey (autoGenerate = true)var contactId:Int,
    var name:String,
    var emailAddress:String,
    var phoneNumber:String,
    var avatar:String
)
