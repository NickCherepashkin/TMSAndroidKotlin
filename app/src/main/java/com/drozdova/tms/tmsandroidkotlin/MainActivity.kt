package com.drozdova.tms.tmsandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.drozdova.tms.tmsandroidkotlin.KotlinActivity.Companion.goToKotlinActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<TextInputEditText>(R.id.et_text)
        val etPassword = findViewById<TextInputEditText>(R.id.et_text2)
        val btnDisplay = findViewById<Button>(R.id.btn_displayText)
        val tvDisplayText = findViewById<TextView>(R.id.tv_displayText)
        val layout1 = findViewById<TextInputLayout>(R.id.textInputLayout)
        val layout2 = findViewById<TextInputLayout>(R.id.textInputLayout2)

        val rb1 = findViewById<RadioButton>(R.id.rd1)
        val rb2 = findViewById<RadioButton>(R.id.rd2)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Info")
            .setMessage("I'm android developer")
            .setCancelable(false)
            .setPositiveButton("OK") {dialog, _ ->
                Toast.makeText(this, "called positive", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("cancel") {dialog, _ ->
                dialog.dismiss()
            }

        btnDisplay.setOnClickListener {
            dialog.show()
            if (etName.text.toString().isEmpty()) {
                layout1.setErrorIconDrawable(R.drawable.ic_baseline_report_gmailerrorred)
                etName.error = "email can't be empty"
//                Toast.makeText(this, "email can't be empty", Toast.LENGTH_LONG).show()
            }else if (etPassword.text.toString().isEmpty()) {
                layout2.setErrorIconDrawable(R.drawable.ic_baseline_report_gmailerrorred)
                etPassword.error = "password can't be empty"
//                etPassword.
                etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
//                Toast.makeText(this, "password can't be empty", Toast.LENGTH_LONG).show()
            } else {
                goToKotlinActivity(this)
                tvDisplayText.text = "${etName.text} ${etPassword.text}"
            }


        }



        rb1.setOnClickListener{
            if(rb1.isChecked){
                rb2.isChecked = false
            }
        }

        rb2.setOnClickListener {
            if(rb2.isChecked){
                rb1.isChecked = false
            }
        }
    }
}