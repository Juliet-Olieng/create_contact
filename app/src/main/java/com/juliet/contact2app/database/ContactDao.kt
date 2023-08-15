package com.juliet.contact2app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juliet.contact2app.model.ContactData


@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact:ContactData)

    @Query("SELECT * FROM Contacts ORDER BY name")
    fun getAllContacts():LiveData<List<ContactData>>
@Query("SELECT * FROM Contacts WHERE contactId = :contactId")
fun getContactById(contactId: ContactData): LiveData<ContactData>

}