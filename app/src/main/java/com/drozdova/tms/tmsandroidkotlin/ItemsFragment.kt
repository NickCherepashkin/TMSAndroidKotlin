package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.ItemModel

const val KEY_FOR_IMAGE = "image"
const val KEY_FOR_TITLE = "title"
const val KEY_FOR_DESCRIPTION = "description"
const val KEY_FOR_TIME = "time"

class ItemsFragment : Fragment(), ItemListener {

    private lateinit var itemAdapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemsList = mutableListOf(
            ItemModel(
                R.drawable.break_dance,
                "Breal Dance",
                "sssssss",
                imageStar = R.drawable.black_star),
            ItemModel(
                R.drawable.hh,
                "Hip-hop",
                "sssssss",
                R.drawable.black_star),
            ItemModel(
                R.drawable.house,
                "House",
                "sssssss",
                R.drawable.black_star),
            ItemModel(
                R.drawable.belly,
                "Belly dance",
                "sssssss",
                R.drawable.black_star),
            ItemModel(
                R.drawable.locking,
                "Locking",
                "sssssss",
                R.drawable.black_star),
            ItemModel(
                R.drawable.krump,
                "Krump",
                "sssssss",
                R.drawable.black_star),
            ItemModel(
                R.drawable.contemp,
                "Contemporary",
                "sssssss",
                R.drawable.black_star))

        val recView = view.findViewById<RecyclerView>(R.id.rv_items_list)
        itemAdapter = ItemsAdapter(this)

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = itemAdapter
        itemAdapter.submitList(itemsList)

    }

    override fun onClick(image: Int, title: String, descript: String, time: String) {
        val detailFragment = ItemDetailFragment()
        val bundle = Bundle()
        bundle.putInt(KEY_FOR_IMAGE, image)
        bundle.putString(KEY_FOR_TITLE, title)
        bundle.putString(KEY_FOR_DESCRIPTION, descript)
        bundle.putString(KEY_FOR_TIME, time)
        detailFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .add(R.id.container, detailFragment)
            .addToBackStack("")
            .commit()
    }
}