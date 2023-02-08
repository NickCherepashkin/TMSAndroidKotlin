package com.drozdova.tms.tmsandroidkotlin.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentOnBoardingBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.OnBoardingPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.OnBoardingView
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.ItemsListFragment
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(), OnBoardingView {
    private var _viewBinding : FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject lateinit var presenter : OnBoardingPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setOnBoardingView(this)

        viewBinding.btnOnRecview.setOnClickListener {
            presenter.showItemsList()
        }
    }

    override fun showList(destination: Int) {
        navigate(destination)
    }

    override fun onDestroy() {
        presenter.saveVisibility(false)
        super.onDestroy()
    }
}