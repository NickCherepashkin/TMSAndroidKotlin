package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class ItemDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imvDancer = view.findViewById<ShapeableImageView>(R.id.imv_item_detail)
        val tvTitle = view.findViewById<MaterialTextView>(R.id.tv_item_title_detail)
        val tvDescription = view.findViewById<MaterialTextView>(R.id.tv_item_description_detail)
        val tvTime = view.findViewById<MaterialTextView>(R.id.tv_item_time_detail)

        val bundle = arguments
        bundle?.let {saveBundle ->
            imvDancer.setBackgroundResource(saveBundle.getInt(KEY_FOR_IMAGE))
            tvTitle.text = saveBundle.getString(KEY_FOR_TITLE)
            tvDescription.text = saveBundle.getString(KEY_FOR_DESCRIPTION)
            tvTime.text = saveBundle.getString(KEY_FOR_TIME)
        }
    }
}