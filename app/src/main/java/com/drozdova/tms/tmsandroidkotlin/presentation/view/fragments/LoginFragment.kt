package com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.repository.LoginRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentLoginBinding
import com.drozdova.tms.tmsandroidkotlin.domain.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.LoginPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.LoginView


class LoginFragment : Fragment(), LoginView {
    private var _viewBinding : FragmentLoginBinding? = null
    val viewBinding get() = _viewBinding!!

    lateinit var loginPresenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginPresenter = LoginPresenter(this, LoginInteractor(LoginRepositoryImpl(requireContext().applicationContext)))

        viewBinding.btnLogin.setOnClickListener {
            if(viewBinding.etLogin.text.toString().isEmpty()) {
                viewBinding.etLogin.error = getString(R.string.error_empty_field)
            } else if (viewBinding.etPass.text.toString().isEmpty()) {
                viewBinding.etPass.error = getString(R.string.error_empty_field)
            } else {
                loginPresenter.loginPresent(viewBinding.etLogin.text.toString())
            }
        }
    }

    override fun login(){
            val fragmentOnBoarding = parentFragmentManager.beginTransaction()
            fragmentOnBoarding.replace(R.id.fragment_container, OnBoardingFragment())
                .addToBackStack("onBoard")
                .commit()
    }
}