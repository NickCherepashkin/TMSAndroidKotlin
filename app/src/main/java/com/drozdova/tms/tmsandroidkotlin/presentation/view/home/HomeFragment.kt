package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentHomeBinding
import com.drozdova.tms.tmsandroidkotlin.App
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.HomeViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.BaseFragment
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.replaceGraph
import com.drozdova.tms.tmsandroidkotlin.utils.coroutines.CoroutinesEx


class HomeFragment : BaseFragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels {viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).appComponent.inject(this)
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