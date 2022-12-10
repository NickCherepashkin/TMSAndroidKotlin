package com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.repository.LoginRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentOnBoardingBinding
import com.drozdova.tms.tmsandroidkotlin.domain.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.OnBoardingPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.OnBoardingView

class OnBoardingFragment : Fragment(), OnBoardingView {
    private var _viewBinding : FragmentOnBoardingBinding? = null
    val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val presenter = OnBoardingPresenter(this, LoginInteractor(LoginRepositoryImpl(requireContext())))
        presenter.setName()
    }

    override fun setName(name: String) {
        viewBinding.materialTextView2.text = name + getString(R.string.logged_in_txt)
    }

}