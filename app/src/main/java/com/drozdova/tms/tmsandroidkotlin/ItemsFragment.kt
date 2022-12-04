package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.listener.ItemListener

class ItemsFragment : Fragment(), ItemListener {

    private lateinit var itemAdapter: ItemsAdapter
    private val itemsViewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recView = view.findViewById<RecyclerView>(R.id.rv_items_list)
        itemAdapter = ItemsAdapter(this)

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = itemAdapter

        itemsViewModel.getData()
        itemsViewModel.items.observe(viewLifecycleOwner) {list ->
            itemAdapter.submitList(list)
        }

        itemsViewModel.bundle.observe(viewLifecycleOwner) { bundleItem ->
            val detailFragment = ItemDetailFragment()
            val bundle = Bundle()
            bundle.putInt(KEY_FOR_IMAGE, bundleItem.imageDance)
            bundle.putString(KEY_FOR_TITLE, bundleItem.title)
            bundle.putString(KEY_FOR_DESCRIPTION, bundleItem.description)
            bundle.putString(KEY_FOR_TIME, bundleItem.time)
            detailFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .add(R.id.container, detailFragment)
                .addToBackStack("")
                .commit()
        }

    }

    override fun onClick(image: Int, title: String, descript: String, time: String) {
        itemsViewModel.itemClicked(image, title, descript, time)
    }
}