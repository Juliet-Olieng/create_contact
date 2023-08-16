package com.juliet.contact2app.database

import com.juliet.contact2app.model.ContactData
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query



@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: ContactData)

    @Query("SELECT * FROM Contacts ORDER BY name")
    fun getAllContacts():LiveData<List<ContactData>>
@Query("SELECT * FROM Contacts WHERE contactId = :contactId")
fun getContactById(contactId: String?): LiveData<ContactData>
}