package com.juliet.contact2app.ui

import ContactDetailsActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juliet.contact2app.databinding.ContactListBinding
import com.juliet.contact2app.model.ContactData
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactRvAdapter(var contactList: List<ContactData>, val context:Context):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding=ContactListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact=contactList[position]
        var binding=holder.binding
        holder.binding.tvName.text=currentContact.name
        holder.binding.tvEmail.text=currentContact.emailAddress
        holder.binding.tvNumber.text=currentContact.phoneNumber
        if (currentContact.avatar.isNotBlank()) {
            Picasso
                .get()
                .load(currentContact.avatar)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(binding.IvContact)
        }
        binding.IvContact.setOnClickListener{
            val intent=Intent(context, ContactDetailsActivity::class.java)
            intent.putExtra("CONTACT_ID",currentContact.contactId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}
class ContactViewHolder(var binding: ContactListBinding): RecyclerView.ViewHolder(binding.root){}