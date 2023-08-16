package com.juliet.contact2app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juliet.contact2app.model.ContactData
import com.juliet.contact2app.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactsViewModel : ViewModel() {
    private val contactsRepo = ContactRepository()
    var contactLiveData: LiveData<ContactData> = MutableLiveData()

    fun saveContact(contact: ContactData) {
        viewModelScope.launch {
            contactsRepo.saveContact(contact)
        }
    }

    fun getContacts(): LiveData<List<ContactData>> {
        return contactsRepo.getDbContact()
    }

    fun getContactById(contactId: String) {
        contactLiveData = contactsRepo.getContactById(contactId)
    }
}