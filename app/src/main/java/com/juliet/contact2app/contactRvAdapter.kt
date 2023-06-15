package com.juliet.contact2app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juliet.contact2app.databinding.ActivityMainBinding
import com.juliet.contact2app.databinding.ContactListBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class contactRvAdapter(var contactList: List<ContactData>):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact=contactList[position]
        var binding=holder.binding
        holder.binding.tvName.text=currentContact.name
        holder.binding.tvEmail.text=currentContact.emailAddress
        holder.binding.tvNumber.text=currentContact.phoneNumber
        Picasso
            .get()
            .load(currentContact.avatar)
            .resize(80,80)
            .centerCrop()
            .transform(CropCircleTransformation())
            .into(binding.ivContact)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}
class ContactViewHolder(var binding: ContactListBinding): RecyclerView.ViewHolder(binding.root){}