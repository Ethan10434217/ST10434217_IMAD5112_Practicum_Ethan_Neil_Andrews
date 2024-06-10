package com.example.st10434217_imad5112_practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

//arrays
val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

val conditionsOfWeek = arrayOf("Sunny", "Overcast", "Partly Cloudy", "Sunny", "Sunny", "Partly Cloudy", "Overcast")

val tempsOfWeek = doubleArrayOf(19.5,17.0,17.0,20.0,22.5,21.0,18.5)

class DetailedScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_screen)

        //declarations
        val txtWeatherDetails = findViewById<TextView>(R.id.txtWeatherDetails)
        val txtMinTemp = findViewById<TextView>(R.id.txtMinimumTemp)
        val txtMaxTemp = findViewById<TextView>(R.id.txtMaximumTemp)
        val btnReturn = findViewById<Button>(R.id.btnReturn)
        val btnFinalExit = findViewById<Button>(R.id.btnFinalExit)
        val maxTemperature = tempsOfWeek.maxOrNull()
        val minTemperature = tempsOfWeek.minOrNull()


        //building the strings from the arrays to be displayed in order
        val stringBuilder = StringBuilder()
        for (i in daysOfWeek.indices) {
            stringBuilder.append("Day: ${daysOfWeek[i]}, Temperature: ${tempsOfWeek[i]} °C\n, Conditions: ${conditionsOfWeek[i]}")
        }

        //displaying the built string in the edit text
        txtWeatherDetails.setText(stringBuilder.toString())


        //displaying the minimum and maximum temps
        txtMaxTemp.text = "Max Temperature: ${maxTemperature ?: "N/A"} °C"
        txtMinTemp.text = "Min Temperature: ${minTemperature ?: "N/A"} °C"

        //setting an on click listener to return the user back to the main page
        btnReturn.setOnClickListener {
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)

        }

        //setting an on click listener to close the app once pressed
        btnFinalExit.setOnClickListener {
            finishAffinity()
        }

        btnFinalExit.setOnClickListener {
            //creating dialog to ask whether the user wants to exit or not
            AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                //creating a yes buttom
                .setPositiveButton("Yes") { dialog, which ->
                    finishAffinity()
                }
                //creating a no button
                .setNegativeButton("No", null)
                .show()


        }


    }





}
