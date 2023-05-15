package com.example.intentapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveActivityWithObject : AppCompatActivity() {
    companion object {
        const val EXTRA_MAHASISWA = "extra_mahasiswa"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val mhs = if (Build.VERSION.SDK_INT >=33 ) {
            intent.getParcelableExtra<Mahasiswa>(EXTRA_MAHASISWA,Mahasiswa::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Mahasiswa>(EXTRA_MAHASISWA)
        }

        if (mhs != null) {
            val text = "Name : ${mhs.name.toString()}, \nkelas : ${mhs.clas}, \nUmur : ${mhs.age}, \nEmail : ${mhs.email}, \nkota : ${mhs.city}"

            tvObject.text = text
        }
    }
}