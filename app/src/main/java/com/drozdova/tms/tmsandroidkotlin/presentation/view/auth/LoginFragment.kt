package com.drozdova.tms.tmsandroidkotlin.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentLoginBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.HomeFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(){
    private var _viewBinding : FragmentLoginBinding? = null
    val viewBinding get() = _viewBinding!!

    private val viewModel : LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnLogin.setOnClickListener {
            if(viewBinding.etLogin.text.toString().isEmpty()) {
                viewBinding.etLogin.error = getString(R.string.error_empty_field)
            } else if (viewBinding.etPass.text.toString().isEmpty()) {
                viewBinding.etPass.error = getString(R.string.error_empty_field)
            } else {
                viewModel.loginUser(
                    viewBinding.etLogin.text.toString(),
                    viewBinding.etPass.text.toString()
                )
            }
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }
    }
}