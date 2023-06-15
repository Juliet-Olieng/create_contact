package com.juliet.contact2app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.juliet.contact2app.databinding.ActivityLogin2Binding
import com.juliet.contact2app.databinding.ActivityMainBinding

class login_Activity : AppCompatActivity() {
    lateinit var binding: ActivityLogin2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.ftButton.setOnClickListener {
//            val intent= Intent(this,login_Activity::class.java)
//            startActivity(intent)
//        }
    }
    override fun onResume() {
        super.onResume()
//        binding.ftButton.setOnClickListener {
//            val intent= Intent(this,login_Activity::class.java)
//            startActivity(intent)
//        }
        binding.btnCreate.setOnClickListener{ validateSignup() }
    }
    fun validateSignup(){
        val name=binding.etName.text.toString()
        val email=binding.etEmail.text.toString()
        val phoneNumber=binding.etPhonenumber.text.toString()
        var error=false

        if (name.isBlank()) {
            binding.tilName.error = "First name is required"
            error = true

        }
        if (email.isBlank()){
            binding.tilEmail.error="First name is required"
            error=true

        }
        if (phoneNumber.isBlank()){
            binding.tilPhonenumber.error="First name is required"
            error=true

        }

        if(!error){
            Toast.makeText(this,"Congradulations Joy on your sign up", Toast.LENGTH_SHORT)
                .show()
        }

    }
}