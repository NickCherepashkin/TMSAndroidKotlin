package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

class ItemsFragment : Fragment(), ItemListener {
    private lateinit var rvFruitAdapter : ItemsAdapter

    private val viewModel : ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_fruits)

        rvFruitAdapter = ItemsAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = rvFruitAdapter


        viewModel.getItems()
        viewModel.items.observe(viewLifecycleOwner) {list ->
            rvFruitAdapter.submitList(list)
        }

        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if(navBundle != null) {
                val detailsFragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putString("name", navBundle.name)
                bundle.putString("date", navBundle.date)
                bundle.putInt("image", navBundle.img)
                detailsFragment.arguments = bundle
                parentFragmentManager.beginTransaction()
                    .replace(R.id.activity_container, detailsFragment)
                    .addToBackStack("")
                    .commit()

                viewModel.userNavigated()
            }

        }


    }

    override fun onClick() {
        Toast.makeText(context, "some message", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {

    }

}