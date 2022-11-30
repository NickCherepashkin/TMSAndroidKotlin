package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

class ItemsFragment : Fragment(), ItemListener {
    private lateinit var rvFruitAdapter : ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listItems = listOf(
            ItemsModel(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.dot_net,
                ".Net",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.delphi,
                "Delphi",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.java,
                "Java",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.python,
                "Python",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.js,
                "Java Script",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            ))

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_fruits)

        rvFruitAdapter = ItemsAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = rvFruitAdapter
        rvFruitAdapter.submitList(listItems)
    }

    override fun onClick() {
        Toast.makeText(context, "some message", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("date", date)
        bundle.putInt("image", imageView)
        detailsFragment.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack("")
            .commit()
    }

}