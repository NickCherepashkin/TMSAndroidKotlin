package com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsBinding
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentSearchBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.ItemsViewModel
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.SearchViewModel
import com.squareup.picasso.Picasso

class SearchFragment : Fragment() {

    private var _binding : FragmentSearchBinding? = null
    val binding get() = _binding!!

    private val viewModel : SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewModel.findItem(p0 ?: "")
                return false
            }

        })

        viewModel.item.observe(viewLifecycleOwner) {
            binding.description.text = it.description
            Picasso.get().load(Uri.parse(it.image)).into(binding.image)
        }
    }
}