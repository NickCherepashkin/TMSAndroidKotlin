package com.drozdova.tms.tmsandroidkotlin.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentLoginBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.LoginPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.LoginView
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.HomeFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.Navigation.setFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginView {
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setLoginView(this)

        binding.btnLogin.setOnClickListener {
            presenter.loginUser(
                binding.etUserName.text.toString(),
                binding.etUserPass.text.toString()
            )
        }
    }

    override fun loginUser() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragments_container, HomeFragment())
            .commit()
    }
}