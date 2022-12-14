package com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentDetailsBinding
import com.drozdova.tms.tmsandroidkotlin.utils.BundleConstants


class DetailsFragment : Fragment() {
    private var _binding : FragmentDetailsBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        bundle?.let { safeBundle ->
            val name = safeBundle.getString(BundleConstants.NAME_KEY)
            val date = safeBundle.getString(BundleConstants.DATE_KEY)
            val image = safeBundle.getInt(BundleConstants.IMAGE_KEY)

            binding.tvDateItemDetails.text = date
            binding.imvItemDetails.setBackgroundResource(image)
            binding.tvTitleItemDetails.text = name
        }
    }
}