package com.example.volumebalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtwidth : EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength:EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView;

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtwidth = findViewById(R.id.edt_Width)
        edtHeight = findViewById(R.id.edt_Height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvResult.text.toString())
    }

    override fun onClick(v: View?) {
       if (v?.id == R.id.btn_calculate) {

           val inputLength = edtLength.text.toString().trim()
           val inputWidth = edtwidth.text.toString().trim()
           val inputHeight = edtHeight.text.toString().trim()

           var isEmpty = false

           if (inputLength.isEmpty()) {
               isEmpty = true
               edtLength.error = "Field ini tidak boleh kosong"
           }

           if (inputWidth.isEmpty()) {
               isEmpty = true
               edtwidth.error = "Field ini tidak boleh kosong"
           }

           if (inputHeight.isEmpty()) {
               isEmpty = true
               edtHeight.error = "Field ini tidak boleh kosong"
           }

           if (!isEmpty) {
               val volume = inputHeight.toDouble() * inputLength.toDouble() * inputWidth.toDouble()
               tvResult.text = volume.toString();
           }
       }
    }
}