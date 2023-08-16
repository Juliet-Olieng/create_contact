package com.juliet.contact2app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juliet.contact2app.model.ContactData
import com.juliet.contact2app.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
    val contactsRepo=ContactRepository()
    lateinit var contactLiveData:LiveData<ContactData>
    fun saveContact(contact:ContactData){
        viewModelScope.launch {
            contactsRepo.saveContact(contact)
        }

    }

    fun getContacts():LiveData<List<ContactData>>{
        return contactsRepo.getDbContact()
    }
    fun getContactById(contactId: Int){
        contactLiveData= contactsRepo.getContactById(contactId)
    }
}