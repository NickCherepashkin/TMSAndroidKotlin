package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentFavouriteBinding
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsListBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.adapter.FavouriteAdapter
import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import com.drozdova.tms.tmsandroidkotlin.presentation.model.User
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.FavouritePresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.FavouriteView
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.ListPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavouriteFragment : Fragment(), FavouriteView {
    private var _bindingList : FragmentFavouriteBinding? = null
    val bindingList get() = _bindingList!!

    private lateinit var adapter: FavouriteAdapter

    @Inject lateinit var presenter: FavouritePresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingList = FragmentFavouriteBinding.inflate(inflater, container, false)
        return bindingList.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FavouriteAdapter()
        bindingList.rvFavList.adapter = adapter
        bindingList.rvFavList.layoutManager = LinearLayoutManager(context)

        presenter.setView(this)
        presenter.getFavourites()
    }

    override fun setData(list: List<FavUser>) {
        adapter.submit(list)
    }
}