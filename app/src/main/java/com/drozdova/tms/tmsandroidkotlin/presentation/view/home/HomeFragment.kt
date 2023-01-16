package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentHomeBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.HomeViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var  _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showUserCreds()
        viewModel.name.observe(viewLifecycleOwner) { name ->
            binding.tvUserCreds.text = name
        }

        binding.btnOnBoarding.setOnClickListener {
            viewModel.goToOnBoarding()
        }

        viewModel.nav.observe(viewLifecycleOwner){
            if (it != null) {
                navigate(it)
                viewModel.onHomeBack()
            }
        }
    }
}