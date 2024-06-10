package com.example.st10434217_imad5112_practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing and creating variables
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnExit = findViewById<Button>(R.id.btnExit)

        //moving the user to the next page of the app
        btnNext.setOnClickListener {
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
        }


        btnExit.setOnClickListener {
            finishAffinity()
        }

        btnExit.setOnClickListener {
            //creating dialog to ask whether the user wants to exit or not
            AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                //creaing a yes buttom
                .setPositiveButton("Yes") { dialog, which ->
                    finishAffinity()
                }
                    //creating a no button
                .setNegativeButton("No", null)
                .show()


        }


    }
}