package com.juliet.contact2app.repository

import androidx.lifecycle.LiveData
import com.juliet.contact2app.Contact2App
import com.juliet.contact2app.database.ContactDb
import com.juliet.contact2app.model.ContactData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactRepository {
    val database = ContactDb.getDataBase(Contact2App.appContext)
    suspend fun saveContact(contact:ContactData){
        withContext(Dispatchers.IO){
            database.contactDao().insertContact(contact)
        }
    }

    fun getDbContact():LiveData<List<ContactData>>{
        return database.contactDao().getAllContacts()
    }
    fun getContactById(contactId:Int):LiveData<ContactData>{
        return database.contactDao().getContactById(contactId)
    }
}