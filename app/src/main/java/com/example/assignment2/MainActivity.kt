package com.example.assignment2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var appDb : AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startLogin(view: View){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    fun startSignup(view: View){
        val intent = Intent(this, Signup::class.java)
        startActivity(intent)
    }
}