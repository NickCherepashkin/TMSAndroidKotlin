package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentHomeBinding
import com.drozdova.tms.tmsandroidkotlin.model.UserModel
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.HomePresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.HomeView
import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.OnBoardingFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var presenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setHomeView(this)
        presenter.showUserCreds()

        binding.btnOnBoarding.setOnClickListener {
            presenter.goToOnBoarding()
        }
    }

    override fun showUserCreds(userModel: UserModel) {
        binding.tvUserCreds.text = "${userModel.name} ${userModel.pass}"
    }

    override fun goToOnBoarding() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragments_container, OnBoardingFragment())
            .commit()
    }

}