package com.drozdova.tms.tmsandroidkotlin.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.presentation.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.data.repository.ItemsRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor

class ItemsFragment : Fragment(), ItemListener {
    private var _binding : FragmentItemsBinding? = null
    val binding get() = _binding!!
    private lateinit var adapter: ItemsAdapter

    private lateinit var interactor : ItemsInteractor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        interactor = ItemsInteractor(ItemsRepositoryImpl())

        adapter = ItemsAdapter(this)
        binding.rvItemsList.adapter = adapter

        val list = interactor.getItemslist()
        adapter.submit(list)
    }

    override fun itemDetailsClick(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("date", date)
        bundle.putInt("image", imageView)
        detailsFragment.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragments_container, detailsFragment)
            .addToBackStack("")
            .commit()
    }

    override fun imageClick() {
        Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
    }
}