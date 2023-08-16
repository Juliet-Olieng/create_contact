package com.juliet.contact2app.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juliet.contact2app.databinding.ContactListBinding
import com.juliet.contact2app.model.ContactData
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

@SuppressLint("IntentWithNullActionLaunch")
class ContactRvAdapter(private var contactList: List<ContactData>) : RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contactList[position]
        val binding = holder.binding
        holder.binding.tvName.text = currentContact.name
        holder.binding.tvEmail.text = currentContact.emailAddress
        holder.binding.tvNumber.text = currentContact.phoneNumber
        if (currentContact.avatar.isNotBlank()) {
            Picasso
                .get()
                .load(currentContact.avatar)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(binding.IvContact)
        }
        binding.IvContact.setOnClickListener {
            val intent = Intent(binding.root.context, ContactDetailsActivity::class.java)
            intent.putExtra("CONTACT_ID", currentContact.contactId)
            binding.root.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}

class ContactViewHolder(var binding: ContactListBinding) : RecyclerView.ViewHolder(binding.root) {}