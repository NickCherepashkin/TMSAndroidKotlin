package com.drozdova.tms.tmsandroidkotlin

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.orange)))

        val tv1 = findViewById<TextView>(R.id.tv1_a2)
        val tv2 = findViewById<TextView>(R.id.tv2_a2)
        tv1.text = intent.getStringExtra(TV_A2_BOLD_TEXT_KEY) ?: getString(R.string.no_text)
        tv2.text = intent.getStringExtra(TV_A2_ITALIC_TEXT_KEY) ?: getString(R.string.no_text)

        if (intent.hasExtra(ACTIVITY_TITLE_KEY)) {
            supportActionBar?.title = intent.getStringExtra(ACTIVITY_TITLE_KEY)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        menu?.setGroupVisible(R.id.menu_a1, false)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.go_back_a1 -> onBackPressed()
            R.id.menu_close -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val ACTIVITY_TITLE_KEY = "A2_TITLE"
        private const val TV_A2_BOLD_TEXT_KEY = "TV_A_BOLD_2"
        private const val TV_A2_ITALIC_TEXT_KEY = "TV_A_ITALIC_2"

        fun goToActivity2(context: Context) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(TV_A2_BOLD_TEXT_KEY, context.getString(R.string.bold_text))
            intent.putExtra(TV_A2_ITALIC_TEXT_KEY, context.getString(R.string.italic_text))
            context.startActivity(intent)
        }

        fun goToActivity2(context: Context, activityTitle: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(ACTIVITY_TITLE_KEY,activityTitle)
            context.startActivity(intent)
        }
    }
}