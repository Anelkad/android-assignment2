package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.Room
import com.example.assignment2.databinding.ActivitySignupBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Signup : AppCompatActivity() {

    private lateinit var appDb: AppDatabase
    lateinit var userDao: UsersDao
    lateinit var binding: ActivitySignupBinding
    var isUserExist = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDb = Room.databaseBuilder(this, AppDatabase::class.java, "AppDb")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()

        userDao = appDb.getDao()

        binding.signUp.setOnClickListener{
            writeData()
        }
    }
    private fun writeData(){
        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
        val password = binding.password.text.toString()
        val login = binding.login.text.toString()

        isUserExist = userDao.isLoginExist(login)


        if(login.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty() && password.isNotEmpty())
        {
            if (isUserExist)
                {Toast.makeText(this,"User login exist!",Toast.LENGTH_SHORT).show()}
            else
                {
                val user = Users(
                    null, login, firstName, lastName, password
                )
                    userDao.insert(user)

                Toast.makeText(this,"Successfully written",Toast.LENGTH_SHORT).show()
                    startSignup()
                }
        }
            else {Toast.makeText(this,"PLease Enter Data",Toast.LENGTH_SHORT).show()}

    }
    private fun startSignup(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}