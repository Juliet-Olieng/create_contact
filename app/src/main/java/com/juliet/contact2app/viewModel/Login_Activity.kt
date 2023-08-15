package com.juliet.contact2app.viewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.juliet.contact2app.R
import com.juliet.contact2app.databinding.ActivityLogin2Binding
import com.juliet.contact2app.model.ContactData

class login_Activity : AppCompatActivity() {
    lateinit var binding: ActivityLogin2Binding
    val contactsViewModel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    override fun onResume() {
        super.onResume()

        binding.btnCreate.setOnClickListener{ validateSignup() }

    }
    fun validateSignup(){
        val name=binding.etName.text.toString()
        val email=binding.etEmail.text.toString()
        val phoneNumber=binding.etPhonenumber.text.toString()
        var error=false

        if (name.isBlank()) {
            binding.tilName.error = getString(R.string.first_name_is_required)
            error = true

        }
        if (email.isBlank()){
            binding.tilEmail.error= getString(R.string.email_is_required)
            error=true

        }
        if (phoneNumber.isBlank()){
            binding.tilPhonenumber.error= getString(R.string.phone_number_is_required)
            error=true

        }

        if(!error){
            val newContact=ContactData(
                contactId = 0,
                name =name,
                phoneNumber =phoneNumber, emailAddress = email, avatar = "")
            contactsViewModel.saveContact(newContact)
            Toast.makeText(this,"Contact created", Toast.LENGTH_SHORT)
                .show()
        }

    }
}