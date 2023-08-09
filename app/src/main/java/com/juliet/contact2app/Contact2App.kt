package com.juliet.contact2app

import android.app.Application
import android.content.Context

class Contact2App:Application() {
    companion object{
        lateinit var appContext:Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
    }
}