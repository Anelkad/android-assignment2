package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignment2.databinding.ActivitySignupBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Signup : AppCompatActivity() {

    private lateinit var appDb : AppDatabase
    private lateinit var binding: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDb = AppDatabase.getDatabase(this)

        binding.signUp.setOnClickListener{
        writeData()
        }
    }
    private fun writeData(){
        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
        val password = binding.password.text.toString()

        if(firstName.isNotEmpty() && lastName.isNotEmpty() && password.isNotEmpty()     ) {
            val user = Users(
                null, firstName, lastName, password
            )
            GlobalScope.launch(Dispatchers.IO) {

                appDb.usersDao().insert(user)
            }

            binding.firstName.text.clear()
            binding.lastName.text.clear()
            binding.password.text.clear()

            Toast.makeText(this,"Successfully written",Toast.LENGTH_SHORT).show()
        }else Toast.makeText(this,"PLease Enter Data",Toast.LENGTH_SHORT).show()

    }
    private fun readData(){

    }

}