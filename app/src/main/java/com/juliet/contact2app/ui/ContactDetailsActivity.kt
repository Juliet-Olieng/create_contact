package com.juliet.contact2app.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.juliet.contact2app.databinding.ActivityContactDetailsBinding
import com.juliet.contact2app.viewModel.ContactsViewModel
import kotlinx.coroutines.launch

class ContactDetailsActivity : AppCompatActivity() {
    private val contactsViewModel: ContactsViewModel by viewModels()
    private lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val selectedContactId: Int = intent.getIntExtra("CONTACT_ID", 0)
        contactsViewModel.getContactById(selectedContactId.toString())
        observeContactIfo()
    }

    private fun observeContactIfo() = lifecycleScope.launch {
        contactsViewModel.contactLiveData.observe(this@ContactDetailsActivity) {
            if (it == null) return@observe
            binding.etName.setText(it.name)
            binding.etNumber.setText(it.phoneNumber)
        }
    }
}

