package com.drozdova.tms.tmsandroidkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.drozdova.tms.tmsandroidkotlin.MainActivityWithList.Companion.startActWithList
import com.google.android.material.button.MaterialButton

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val btn = findViewById<MaterialButton>(R.id.btnKotAct)
        val btn2 = findViewById<MaterialButton>(R.id.btnKotAct2)

        // просто анонимный класс
        val person = object {
            val name = "Nick"
            fun develop() {
                Log.w("anonimys class", "called develop fun")
            }
        }

        // наследование от интерфейса
        val person_2 = object : Developer {
            val name = "Cherepash"
            override fun developer() {
                Log.w("anonimys class", "called develop fun interface")
            }

        }

        val house = HouseBuilder.Builder
            .setStock(3)
            .setSwimmingPool(false)
            .build()

        btn.setOnClickListener {
            Log.w("houseBuilder", "${house.howManyStocks()} ${house.hasSwPool()}")
            person.develop()
            Toast.makeText(this, person.name, Toast.LENGTH_LONG).show()
        }

        btn2.setOnClickListener {
            startActWithList(this)
        }

        val lambda = {string: String -> Toast.makeText(this, "your text is $string", Toast.LENGTH_LONG).show()}

        lambda("set text in lambda")

        makeRequest("https://www.youtube.com") { callbackResult ->
            Log.w("callback result", callbackResult)
        }

        returnnAnonymClass("Stroka").develop()
    }

    private fun returnnAnonymClass(string: String) = object {
        fun develop() {
            Log.w("return anonimys class", "called develop fun interface $string")
        }
    }

    fun callAnonymClass(developer: Developer) {
        developer.developer()
    }

    fun makeRequest(url: String, argForCallBack: (string: String) -> Unit) {
        argForCallBack.invoke("callbackResult $url")
    }

    companion object {
        fun goToKotlinActivity(context: Context) {
            context.startActivity(Intent(context, KotlinActivity::class.java))
        }
    }
}

interface Developer {
    fun developer()
}