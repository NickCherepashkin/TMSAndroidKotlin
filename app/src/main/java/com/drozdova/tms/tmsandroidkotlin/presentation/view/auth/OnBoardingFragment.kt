package com.drozdova.tms.tmsandroidkotlin.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentOnBoardingBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.ItemsListFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment(){
    private var _viewBinding : FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: OnBoardingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnOnRecview.setOnClickListener {
            viewModel.showList()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ItemsListFragment())
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}