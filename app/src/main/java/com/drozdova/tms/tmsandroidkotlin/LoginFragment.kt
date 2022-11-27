package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSignIn = view.findViewById<MaterialButton>(R.id.btn_sign_in)
        val btnRegistration = view.findViewById<MaterialButton>(R.id.btn_registration)

        val etLogin = view.findViewById<TextInputEditText>(R.id.et_login)
        val etPass = view.findViewById<TextInputEditText>(R.id.et_pass)
        val etLoginLayout = view.findViewById<TextInputLayout>(R.id.et_layout_login)
        val etPassLayout = view.findViewById<TextInputLayout>(R.id.et_layout_pass)

        btnSignIn.setOnClickListener {
            if (etLogin.text.toString().isEmpty()) {
                etLoginLayout.error = "Login can't to be empty"
            } else if (etPass.text.toString().isEmpty()) {
                etLoginLayout.error = ""
                etPassLayout.error = "Password can't to be empty"
            } else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, HomeFragment())
                    .commit()
            }
        }

        btnRegistration.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, RegistrationFragment())
                .addToBackStack("")
                .commit()
        }
    }
}