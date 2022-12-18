package com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.model.Item
import com.drozdova.tms.tmsandroidkotlin.data.repository.ItemsRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentListBinding
import com.drozdova.tms.tmsandroidkotlin.domain.ListInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.ListPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.ListView
import com.drozdova.tms.tmsandroidkotlin.presentation.view.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.presentation.view.listener.ItemsListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class ListFragment : Fragment(), ListView, ItemsListener {
    private var _bindingList : FragmentListBinding? = null
    val bindingList get() = _bindingList!!

    private lateinit var adapter: ItemsAdapter

    @Inject lateinit var presenter: ListPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingList = FragmentListBinding.inflate(inflater)
        return bindingList.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ItemsAdapter(this)
        bindingList.recViewList.adapter = adapter
        bindingList.recViewList.layoutManager = LinearLayoutManager(context)

        presenter.getData()
    }

    override fun setData(list: List<Item>) {
        adapter.submit(list)
    }

    override fun isItemSelected(isSelect : Boolean) {
        val msg : String
        if (isSelect) {
            msg = getString(R.string.checked_txt)
        } else {
            msg = getString(R.string.not_checked_txt)
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}