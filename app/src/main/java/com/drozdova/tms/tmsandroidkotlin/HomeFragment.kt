package com.drozdova.tms.tmsandroidkotlin

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val alertDialog = AlertDialog.Builder(view.context)
            .setTitle("Congrat")
            .setMessage("Successfully")
            .setPositiveButton("Cancel") {dialog, _->
                dialog.dismiss()
            }

        alertDialog.show()
    }
}