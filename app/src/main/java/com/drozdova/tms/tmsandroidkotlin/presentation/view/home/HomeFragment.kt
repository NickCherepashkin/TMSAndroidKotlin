package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentHomeBinding
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentLoginBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.OnBoardingFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.HomeViewModel
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.LoginViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.navigate
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.replaceGraph
import com.drozdova.tms.tmsandroidkotlin.utils.coroutines.CoroutinesEx
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showUserData()

        CoroutinesEx().testCoroutineCancel()

        binding.btnOnBoarding.setOnClickListener {
            viewModel.navToOnBoarding()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if(it != null) {
                replaceGraph(it)
            }
        }

        viewModel.userCreds.observe(viewLifecycleOwner) { user ->
            binding.tvUserCreds.text = "${user.name} ${user.pass}"
        }
    }

}