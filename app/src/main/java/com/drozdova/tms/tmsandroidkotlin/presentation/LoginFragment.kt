package com.drozdova.tms.tmsandroidkotlin.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _viewBinding : FragmentLoginBinding? = null
    val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnLogin.setOnClickListener {
            if(viewBinding.etLogin.text.toString().isEmpty()) {
                viewBinding.etLogin.error = getString(R.string.error_empty_field)
            } else if (viewBinding.etPass.text.toString().isEmpty()) {
                viewBinding.etPass.error = getString(R.string.error_empty_field)
            } else {
                val bundle = Bundle()
                bundle.putString("login", viewBinding.etLogin.text.toString())

                val fragmentOnBoard = OnBoardingFragment()
                fragmentOnBoard.arguments = bundle

                val fragmentOnBoarding = parentFragmentManager.beginTransaction()
                fragmentOnBoarding.replace(R.id.fragment_container, fragmentOnBoard)
                    .addToBackStack("onBoard")
                    .commit()
            }
        }
    }
}