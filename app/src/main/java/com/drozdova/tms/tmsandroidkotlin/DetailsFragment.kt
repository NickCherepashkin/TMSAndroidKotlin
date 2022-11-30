package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.detailsName)
        val detailsDate = view.findViewById<TextView>(R.id.detailsDate)
        val detailsNImage = view.findViewById<ImageView>(R.id.detailsImage)

        val bundle = arguments
        bundle?.let { safeBundle ->
            val name = safeBundle.getString("name")
            val date = safeBundle.getString("date")
            val image = safeBundle.getInt("image")

            detailsDate.text = date
            detailsNImage.setBackgroundResource(image)
            detailsName.text = name
        }

    }
}