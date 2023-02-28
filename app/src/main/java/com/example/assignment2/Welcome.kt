package com.example.assignment2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast

class Welcome : AppCompatActivity() {
    lateinit var button: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        button = findViewById(R.id.menu_button)

        button.setOnClickListener{

        val popupMenu = PopupMenu(this,it)
        popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener {
            menuItem ->
            Toast.makeText(this, "You Clicked " + menuItem.title, Toast.LENGTH_SHORT).show()
            true
        }
       popupMenu.show()
    }
    }
}