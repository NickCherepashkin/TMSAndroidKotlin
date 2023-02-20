package com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.net.Uri
import android.os.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentSearchBinding
import com.drozdova.tms.tmsandroidkotlin.App
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.SearchViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.BaseFragment
import com.squareup.picasso.Picasso


class SearchFragment : BaseFragment(){

    private var _binding : FragmentSearchBinding? = null
    val binding get() = _binding!!

    private val viewModel : SearchViewModel by viewModels{viewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as App).appComponent.inject(this)

        val btn = Button(context)
        btn.background = context?.getDrawable(R.drawable.android)
        btn.text = context?.getString(R.string.btn_log_in_txt)

        binding.root.addView(btn)

        AnimationUtils.loadAnimation(context, R.anim.rotate_anim).also {
            binding.start.startAnimation(it)
        }

        val animatorSet = AnimatorSet()
        val y = ObjectAnimator.ofFloat(binding.start, "scaleY", 5f, 1f)
        val x = ObjectAnimator.ofFloat(binding.start, "scaleX", 5f, 1f)

        animatorSet.playTogether(x, y)
        animatorSet.start()


        val translate = ValueAnimator.ofFloat(2f, 1.5f)
        translate.addUpdateListener { animation ->
            val scale = animation.animatedValue.toString().toFloat()
            binding.stop.setScaleX(scale)
            binding.stop.setScaleY(scale)
        }
        translate.repeatCount = 5
        translate.start()


        binding.search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewModel.findItem(p0 ?: "")
                return false
            }
        })

        viewModel.item.observe(viewLifecycleOwner) {
            binding.description.text = it.description
            Picasso.get().load(Uri.parse(it.image)).into(binding.image)
        }

        runHandler()
    }

    private fun runHandler(){
        var backgroundHandler: Handler? = null

        //Creating a background thread.
        val backgroundThread = Thread {
            //Creating a Looper for this thread.
            Looper.prepare()

            //Looper.myLooper() gives you Looper for current Thread.
            val myLooper = Looper.myLooper()!!

            //Creating a Handler for given Looper object.
            backgroundHandler = Handler(myLooper) { msg ->

                //Processing incoming messages for this Handler.
                //Receiving extras from Message
                val bundle: Bundle? = msg.data

                Log.d("", "Handler:: Extras: ${bundle}")

                Log.d("", "Handler:: Background Thread ID ${Thread.currentThread().id}")

                //myLooper.quit()
                true
            }

            Looper.loop()
        }
        backgroundThread.start()


        //Click listener on a Button
        binding.start.setOnClickListener {
            Log.d("", "Handler:: UI Thread ID ${Thread.currentThread().id}")

            //Executing code on backgroundThread using Handler.
            backgroundHandler!!.post {
                //Here, you'll note that Thread's ID is of backgroundThread.
                Log.d("", "Handler:: Background Thread ID ${Thread.currentThread().id}")
            }

            // Now, sending data on backgroundThread using Message object. Handler's handleMessage(msg: Message?) method will receive this Message and perform appropriate action.
            val extras = Bundle()
            extras.putInt("PRICE", 100)
            extras.putString("PRODUCT_NAME", "Table Lamp")

            val message = Message.obtain(backgroundHandler)
            message.data = extras

            backgroundHandler?.sendMessage(message)
        }
    }

}