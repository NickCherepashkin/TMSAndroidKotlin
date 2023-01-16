package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentDetailsBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.DetailsViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.BundleConstants
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private var _binding : FragmentDetailsBinding? = null
    val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModels()

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

        binding.btnLogOut.setOnClickListener {
            viewModel.logoutUser()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                replaceGraph(it)
            }
        }
    }
}