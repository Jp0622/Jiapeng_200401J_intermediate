package com.example.jiapeng_200401j_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*



class MovieDetail : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val textView: TextView = findViewById(R.id.review)

        registerForContextMenu(textView)

        val intent = getIntent()
        val title = intent.getStringExtra("Title")
        val descpt = intent.getStringExtra("Description")
        val language = intent.getStringExtra("Language")
        val releasedate = intent.getStringExtra("Release date")
        val reason = intent.getStringExtra("Suitable")
        val why = intent.getStringExtra("Reason")


        nameET.text = title.toString()
        descptET.text = descpt.toString()
        radio_language.text = language.toString()
        redateET.text = releasedate.toString()
        chkbx_notforall.text = reason.toString() + "(" + why.toString() + ")"

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)


        menuInflater.inflate(R.menu.review, menu)

    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item!!.itemId) {
            R.id.option1 -> {
                val intent = Intent(this@MovieDetail, RatingActivity::class.java)

                startActivity(intent)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


