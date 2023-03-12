package com.example.assignment2

import android.content.Intent
import android.content.Intent.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.Room
import com.example.assignment2.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Login : AppCompatActivity() {

    private lateinit var appDb : AppDatabase
    lateinit var userDao: UsersDao
    private lateinit var binding: ActivityLoginBinding
    var isUserExist = false
    var isUserRegistered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDb = Room.databaseBuilder(this, AppDatabase::class.java, "AppDb")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()

        userDao = appDb.getDao()

        binding.loginButton.setOnClickListener{
            login()
        }
    }
    private fun login(){
        val password = binding.password.text.toString()
        val login = binding.login.text.toString()

        isUserExist = userDao.isLoginExist(login)


        if(login.isNotEmpty() && password.isNotEmpty())
        {
            if (!isUserExist)
            {
                Toast.makeText(this,"User login don't exist! Sign Up!", Toast.LENGTH_SHORT).show()}
            else
            {
                isUserRegistered = userDao.isUserRegistered(login,password)
                if (isUserRegistered){
                    Toast.makeText(this,"Successfully login", Toast.LENGTH_SHORT).show()
                    startWelcome()
                }
                else{
                    Toast.makeText(this,"Wrong password!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            Toast.makeText(this,"PLease Enter Data", Toast.LENGTH_SHORT).show()}
            }
    private fun startWelcome(){
        val intent = Intent(this, Welcome::class.java)
        startActivity(intent)
    }
    fun startSignup(view: View){
        val intent = Intent(this, Signup::class.java)
        intent.flags = FLAG_ACTIVITY_NO_HISTORY
        startActivity(intent)
    }


}