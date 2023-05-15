package com.example.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivitywithData: Button = findViewById(R.id.btn_move_activity_with_data)
        btnMoveActivitywithData.setOnClickListener(this)

        val btnMoveActivitywithObject: Button = findViewById(R.id.btn_move_activity_with_object)
        btnMoveActivitywithObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this,MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_with_data  -> {
                val moveIntentWithData = Intent(this,MoveActivityWithData::class.java)
                moveIntentWithData.putExtra(MoveActivityWithData.YOUR_NAME,"Antini permatasari")
                moveIntentWithData.putExtra(MoveActivityWithData.YOUR_CLASS,"TI.20.B.1")
                moveIntentWithData.putExtra(MoveActivityWithData.YOUR_AGE,40)
                startActivity(moveIntentWithData)

            }

            R.id.btn_move_activity_with_object -> {
                val objectmhs = Mahasiswa (
                    "Antini permatasari",
                     "TI.20.B.1",
                    21,
                    "antinipermatasari2001@gmail.com",
                    "Bekasi"
                        )

                val movewithObject = Intent(this, MoveActivityWithObject::class.java)
                 movewithObject.putExtra(MoveActivityWithObject.EXTRA_MAHASISWA,objectmhs)
                startActivity(movewithObject)

            }

        }

    }
}