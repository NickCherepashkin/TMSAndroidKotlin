package com.drozdova.tms.tmsandroidkotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.ActivityMainBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.MainPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.MainView
import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.LoginFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null

    @Inject lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)

        presenter.setMainView(this)
        presenter.userIsExist()
    }

    override fun userIsExist(doesUserExisr : Boolean) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.fragments_container,
            when(doesUserExisr) {
                true -> HomeFragment()
                false -> LoginFragment()
            }
        )
        fragment.commit()
    }
}