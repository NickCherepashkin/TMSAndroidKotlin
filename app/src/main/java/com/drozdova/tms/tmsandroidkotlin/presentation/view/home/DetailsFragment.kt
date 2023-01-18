package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentDetailsBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.DetailsPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.DetailsView
import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.LoginFragment
import com.drozdova.tms.tmsandroidkotlin.utils.BundleConstants
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {
    private var _binding : FragmentDetailsBinding? = null
    val binding get() = _binding!!

    @Inject lateinit var presenter : DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        bundle?.let { safeBundle ->
            val name = safeBundle.getString(BundleConstants.ITEM_NAME)
            val date = safeBundle.getString(BundleConstants.ITEM_DATE)
            val image = safeBundle.getInt(BundleConstants.ITEM_IMAGE)

            binding.tvDateItemDetails.text = date
            binding.imvItemDetails.setBackgroundResource(image)
            binding.tvTitleItemDetails.text = name
        }

        presenter.setDetailsView(this)

        binding.btnLogOut.setOnClickListener {
            presenter.logout()
        }
    }

    override fun logout(destination: Int) {
        replaceGraph(destination)
    }
}