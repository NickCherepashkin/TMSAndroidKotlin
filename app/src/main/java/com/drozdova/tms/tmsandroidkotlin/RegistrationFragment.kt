package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegistr = view.findViewById<MaterialButton>(R.id.btn_registr)

        val etLogin = view.findViewById<TextInputEditText>(R.id.etLogin)
        val etPass = view.findViewById<TextInputEditText>(R.id.etPass)
        val etLoginLayout = view.findViewById<TextInputLayout>(R.id.layout_login)
        val etPassLayout = view.findViewById<TextInputLayout>(R.id.layout_pass)

        btnRegistr.setOnClickListener {
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
    }
}