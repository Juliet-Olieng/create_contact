package com.juliet.contact2app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.juliet.contact2app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val button = findViewById<FloatingActionButton>(R.id.ftButton)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, login_Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        displayContact()


    }


    fun displayContact() {
        var contact1 = ContactData("daddy", "nicholas@gmail.com", "+254723469938","https://media.istockphoto.com/id/1389348844/photo/studio-shot-of-a-beautiful-young-woman-smiling-while-standing-against-a-grey-background.jpg?s=1024x1024&w=is&k=20&c=C772iuu-JdrSc1ficwNVDaSLQp3-II9OEpDpxPgmXPg=")
        var contact2 = ContactData("phelix", "phaliza@gmail.com", "+254703728432","https://media.istockphoto.com/id/1432226243/photo/happy-young-woman-of-color-smiling-at-the-camera-in-a-studio.webp?b=1&s=170667a&w=0&k=20&c=HnVO0QRDl31Jb7HI7ly-Kepn58TzM_TwYpHMsktn9do=")
        var contact3 = ContactData("dester", "dester@gmail.com", "+254703924627","https://images.unsplash.com/photo-1605980776566-0486c3ac7617?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=449&q=80")
        var contact4 = ContactData("juliet", "juliet@gmail.com", "+254718492299","https://images.unsplash.com/photo-1621905252472-943afaa20e20?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
        var contact5 = ContactData("teves", "teves@gmail.com", "+254718493474","https://images.unsplash.com/photo-1507152832244-10d45c7eda57?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
        var contact6 = ContactData("tamara", "tamara@gmail.com", "+254718494523","https://images.unsplash.com/photo-1529688530647-93a6e1916f5f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
        var contact7 = ContactData("wein", "wein@gmail.com", "+254718497733","https://media.istockphoto.com/id/1418146721/photo/photo-of-charming-cool-young-man-wear-white-shirt-dark-eyewear-dancing-isolated-pink-color.webp?b=1&s=170667a&w=0&k=20&c=nLdq5v6vYPsozZQPt8gJF4M_zw3tm9HKoetwC07lcTg=")
        var contactlists = listOf<ContactData>(contact1, contact2, contact3, contact4,contact5,contact6,contact7)
        binding.rvContact.layoutManager = LinearLayoutManager(this)
        var contactAdapter = contactRvAdapter(contactlists)
        binding.rvContact.adapter = contactAdapter

    }

}