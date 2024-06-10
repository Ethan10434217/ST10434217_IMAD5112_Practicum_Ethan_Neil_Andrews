package com.example.st10434217_imad5112_practicum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Half
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog


class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        //arrays
        val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

        val tempsOfWeek = doubleArrayOf(19.5,17.0,17.0,20.0,22.5,21.0,18.5)

        //declarations
        val btnSecondExit = findViewById<Button>(R.id.btnSecondExit)
        val btnLastPage = findViewById<Button>(R.id.btnLastScreen)
        val edtDaysOfWeek = findViewById<EditText>(R.id.edtDaysOfWeek)
        val edtAvgTemps = findViewById<EditText>(R.id.edtAvgTemps)
        val btnClear = findViewById<Button>(R.id.btnClear)


        //setting an on click listener to
        //get the user to the next page when the button is pressed
        btnLastPage.setOnClickListener { val intent = Intent(this, DetailedScreen::class.java)
            startActivity(intent) }

        //setting a on click listener to close the app when the button is pressed
        btnSecondExit.setOnClickListener {
            finishAffinity()
        }

        btnSecondExit.setOnClickListener {
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

        //loop to calculate avg temps
        //initializing varable
        var totalWeeklyTemps = 0.0
        for (temperatures in tempsOfWeek) {
            totalWeeklyTemps += temperatures
        }

        //calculating the average
        val avgWeeklyTemps = totalWeeklyTemps / tempsOfWeek.size

        // Format the arrays as a string
        val stringBuilder = StringBuilder()
        for (i in daysOfWeek.indices) {
            stringBuilder.append("Day: ${daysOfWeek[i]}, Temperature: ${tempsOfWeek[i]} °C\n")
        }

        edtDaysOfWeek.setText(stringBuilder.toString())

        //setting the format of the avg temp to degrees celcius
        edtAvgTemps.setText(String.format("%.2f °C", avgWeeklyTemps))


        btnClear.setOnClickListener {
            // Clear the current temperatures array
        }

    }







}