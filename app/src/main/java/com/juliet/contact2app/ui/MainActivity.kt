package com.juliet.contact2app.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.juliet.contact2app.databinding.ActivityMainBinding
import com.juliet.contact2app.model.ContactData
import com.juliet.contact2app.viewModel.ContactsViewModel
import com.juliet.contact2app.viewModel.login_Activity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ftButton.setOnClickListener {
            val intent = Intent(this@MainActivity, login_Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.getContacts().observe(this) { contacts -> displayContact(contacts) }
    }

    private fun displayContact(contactList: List<ContactData>) {
        val contactAdapter = ContactRvAdapter(contactList, this)
        binding.rvContact.layoutManager = LinearLayoutManager(this)
        binding.rvContact.adapter = contactAdapter

    }

}