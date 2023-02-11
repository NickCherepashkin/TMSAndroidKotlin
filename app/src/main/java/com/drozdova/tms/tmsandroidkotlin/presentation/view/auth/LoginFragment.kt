package com.drozdova.tms.tmsandroidkotlin.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentLoginBinding
import com.drozdova.tms.tmsandroidkotlin.di.App
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.LoginViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.BaseFragment
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.navigate
import javax.inject.Inject


class LoginFragment : BaseFragment() {
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container, false)
//        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as App).appComponent.inject(this)

        binding.btnLogin.setOnClickListener {
            viewModel.loginUser(
                binding.etUserName.text.toString(),
                binding.etUserPass.text.toString()
            )
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if(it != null) {
                navigate(it)
                viewModel.userNavigated()
            }
        }
    }
}