package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentDetailsBinding
import com.drozdova.tms.tmsandroidkotlin.App
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.DetailsViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.BaseFragment
import com.drozdova.tms.tmsandroidkotlin.utils.BundleConstants
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.replaceGraph


class DetailsFragment : BaseFragment() {
    private var _binding : FragmentDetailsBinding? = null
    val binding get() = _binding!!

    private val viewModel : DetailsViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as App).appComponent.inject(this)

        val bundle = arguments
        bundle?.let { safeBundle ->
            val name = safeBundle.getString(BundleConstants.NAME_KEY)
            val date = safeBundle.getString(BundleConstants.DATE_KEY)
            val image = safeBundle.getInt(BundleConstants.IMAGE_KEY)

            binding.tvDateItemDetails.text = date
            binding.imvItemDetails.setBackgroundResource(image)
            binding.tvTitleItemDetails.text = name
        }

        binding.btnLogout.setOnClickListener() {
            viewModel.logoutUser()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                val graph = findNavController().navInflater.inflate(it)
                graph.setStartDestination(R.id.loginFragment)
                findNavController().graph = graph
            }
            replaceGraph(it!!)
        }
    }
}