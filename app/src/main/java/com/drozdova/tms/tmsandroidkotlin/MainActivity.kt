package com.drozdova.tms.tmsandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etLogin = findViewById<TextInputEditText>(R.id.etLogin)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val etLayoutLogin = findViewById<TextInputLayout>(R.id.textInputLayoutLogin)
        val etLayoutPassword = findViewById<TextInputLayout>(R.id.textInputLayoutPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Congrats!!!")
            .setPositiveButton("OK") {
                dialog, _-> dialog.dismiss()
            }

        btnLogin.setOnClickListener {
            if (etLogin.text.toString().isEmpty()) {
                etLayoutLogin.setErrorIconDrawable(R.drawable.ic_baseline_error)
                etLogin.error = getString(R.string.empty_login_message)
            } else if (etPassword.text.toString().isEmpty()) {
                etLayoutPassword.setErrorIconDrawable(R.drawable.ic_baseline_error)
                etPassword.error = getString(R.string.pass_empty_message)
            } else {
                dialog.setMessage("Your login: ${etLogin.text.toString()} and password: ${etPassword.text.toString()} are correct")
                dialog.show()
            }
        }
    }
}