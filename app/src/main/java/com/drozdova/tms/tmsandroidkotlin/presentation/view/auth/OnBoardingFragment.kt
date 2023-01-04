package com.drozdova.tms.tmsandroidkotlin.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentOnBoardingBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.OnBoardingPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.OnBoardingView
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.ItemsFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.Navigation.setFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(), OnBoardingView {
    private var _binding : FragmentOnBoardingBinding? = null
    private val binding: FragmentOnBoardingBinding get() = _binding!!

    @Inject lateinit var presenter : OnBoardingPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setOnBoardingView(this)

        binding.btnShowList.setOnClickListener {
            presenter.goToItemsFragment()
        }
    }

    override fun goToItemsFragment() {
        setFragment(parentFragmentManager, ItemsFragment())
    }
}