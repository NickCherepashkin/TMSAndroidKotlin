package com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.repository.OnBoardingRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentOnBoardingBinding
import com.drozdova.tms.tmsandroidkotlin.domain.OnBoardingInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.OnBoardModelFactory
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.OnBoardingViewModel

class OnBoardingFragment : Fragment() {
    private var _viewBinding : FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel : OnBoardingViewModel by viewModels {
        OnBoardModelFactory(OnBoardingInteractor(OnBoardingRepositoryImpl(requireContext())))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getName()

        viewModel.name.observe(viewLifecycleOwner){ name ->
            viewBinding.materialTextView2.text = name + getString(R.string.logged_in_txt)
        }

        viewBinding.btnOnRecview.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListFragment())
                .addToBackStack("")
                .commit()
        }
    }
}