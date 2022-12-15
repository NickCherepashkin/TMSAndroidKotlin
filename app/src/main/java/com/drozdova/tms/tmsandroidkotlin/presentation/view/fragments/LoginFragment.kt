package com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentLoginBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.LoginViewModel
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.Navigation
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.Navigation.setFragment

class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.viewHandler = ViewHandler()
        binding.lifecycleOwner = viewLifecycleOwner
    }

    inner class ViewHandler {
        fun goToTheOnBoarding() {
            setFragment(parentFragmentManager, OnBoardingFragment())
        }
    }

}