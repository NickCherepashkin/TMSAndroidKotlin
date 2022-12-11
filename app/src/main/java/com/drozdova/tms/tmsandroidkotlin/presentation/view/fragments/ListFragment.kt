package com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.drozdova.tms.tmsandroidkotlin.data.repository.ItemsRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentListBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.view.adapter.ItemsAdapter

class ListFragment : Fragment() {
    private var _bindingList : FragmentListBinding? = null
    val bindingList get() = _bindingList!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingList = FragmentListBinding.inflate(inflater)
        return bindingList.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ItemsAdapter()
        bindingList.recViewList.adapter = adapter
        bindingList.recViewList.layoutManager = LinearLayoutManager(context)
        adapter.submit(ItemsRepositoryImpl().getData())
    }
}