package com.drozdova.tms.tmsandroidkotlin.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.ItemsRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsBinding
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.presentation.adapter.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

class ItemsFragment : Fragment(), ItemListener, ItemsView {
    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var rvFruitAdapter : ItemsAdapter

    lateinit var presenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImpl()))

        rvFruitAdapter = ItemsAdapter(this)
        viewBinding.rvFruits.adapter = rvFruitAdapter

        presenter.getData()
    }

    override fun onClick() {
        presenter.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        presenter.elementSelected(name, date, imageView)
    }

    override fun dataReceived(listItems: List<ItemsModel>) {
        rvFruitAdapter.submitList(listItems)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun goToDetails(name: String, date: String, imageView: Int) {
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