package com.example.intentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveActivityWithData : AppCompatActivity() {
    companion object {
        const val YOUR_NAME = "your_name"
        const val YOUR_CLASS = "your_class"
        const val YOUR_AGE  = "your_age"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceived: TextView= findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra(YOUR_NAME)
        val clas = intent.getStringExtra(YOUR_CLASS)
        val age = intent.getIntExtra(YOUR_AGE,0)

        val text = "Your Name : $name, Your Class : $clas, Your Age : $age"

        tvDataReceived.text = text
    }
}