package com.juliet.contact2app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.juliet.contact2app.R
import com.juliet.contact2app.databinding.ActivityContactDetailsBinding
import com.juliet.contact2app.viewModel.ContactsViewModel

class ContactDetailsActivity : AppCompatActivity() {
//    val contactsViewModel:ContactsViewModel by viewModels()
    var contactId=0
    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_contact_details)
        var bundle=intent.extras
        if (bundle!=null){
            contactId =bundle.getInt("CONTACT_ID")
            Toast.makeText(this,"Contact details", Toast.LENGTH_SHORT).show()
        }
    }
}