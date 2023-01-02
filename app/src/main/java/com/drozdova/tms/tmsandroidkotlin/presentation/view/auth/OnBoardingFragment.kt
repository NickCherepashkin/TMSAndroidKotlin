package com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentOnBoardingBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.Navigation.setFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.OnBoardingViewModel

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
                setFragment(parentFragmentManager, ItemsFragment())
                viewModel.onBoardingBack()
            }
        }
    }
}