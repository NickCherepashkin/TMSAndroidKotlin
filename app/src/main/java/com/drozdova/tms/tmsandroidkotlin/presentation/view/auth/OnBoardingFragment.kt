package com.drozdova.tms.tmsandroidkotlin.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentOnBoardingBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.OnBoardingViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.navigateWithDeletedBackStack

class OnBoardingFragment : Fragment() {
    private var _binding : FragmentOnBoardingBinding? = null
    private val binding: FragmentOnBoardingBinding get() = _binding!!

    private val viewModel : OnBoardingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnShowList.setOnClickListener {
            viewModel.onBtnClick()
        }

        viewModel.btnShowList.observe(viewLifecycleOwner) {
            if (it != null) {
                navigateWithDeletedBackStack(it.destinationId, it.fragmentTRemovw)
                viewModel.onBoardingBack()
            }
        }
    }
}