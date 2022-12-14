package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.drozdova.tms.tmsandroidkotlin.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsBinding
import com.drozdova.tms.tmsandroidkotlin.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.Item

class ItemsFragment : Fragment(), ItemListener {
    private var _binding : FragmentItemsBinding? = null
    val binding get() = _binding!!
    private lateinit var adapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listItems = listOf(
            Item(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            Item(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            ),
            Item(
                R.drawable.dot_net,
                ".Net",
                "26.02.2022"
            ),
            Item(
                R.drawable.delphi,
                "Delphi",
                "26.02.2022"
            ),
            Item(
                R.drawable.java,
                "Java",
                "26.02.2022"
            ),
            Item(
                R.drawable.python,
                "Python",
                "26.02.2022"
            ),
            Item(
                R.drawable.js,
                "Java Script",
                "26.02.2022"
            ),
            Item(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            Item(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            )
        )

        adapter = ItemsAdapter(this)
        binding.rvItemsList.adapter = adapter
        adapter.submit(listItems)
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