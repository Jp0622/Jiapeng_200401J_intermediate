package com.example.jiapeng_200401j_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovieActivity : AppCompatActivity() {

    var language = ""
    var notForAll = ""
    var reason = ""
    var suitable = "Yes"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        chkbx_notforall.setOnClickListener {
            if (chkbx_notforall.isChecked()) {
                chkbx_violence.setVisibility(View.VISIBLE)
                chkbx_language.setVisibility(View.VISIBLE)
                notForAll = chkbx_notforall.isChecked.toString()
            }

            else {
                chkbx_violence.setVisibility(android.view.View.GONE)
                chkbx_language.setVisibility(android.view.View.GONE)
                notForAll = chkbx_notforall.isChecked.toString()
            }
        }

        nameET.setOnClickListener{
            if (nameET.length()<1){
                nameET.setError("Field Empty")
            }
        }
        descptET.setOnClickListener{
            if (descptET.length()<1){
                descptET.setError("Field Empty")
            }
        }
        redateET.setOnClickListener{
            if (redateET.length()<1){
                redateET.setError("Field Empty")
            }
        }


        radiogrp.setOnCheckedChangeListener(
            object: RadioGroup.OnCheckedChangeListener{
                override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                    if (checkedId == R.id.radio_english) {
                        language = "English"
                    }
                    else if (checkedId == R.id.radio_chinese) {
                        language = "Chinese"
                    }
                    else if (checkedId == R.id.radio_malay) {
                        language = "Malay"
                    }
                    else if (checkedId == R.id.radio_Tamil) {
                        language = "Tamil"
                    }
                }
            }
        )

        btn_submit.setOnClickListener{
            val name = nameET.text.toString()
            val descpt = descptET.text.toString()
            val releaseDate = redateET.text.toString()


            if(chkbx_notforall.isChecked){

                suitable = "No"
                reason = ""

                if (chkbx_violence.isChecked){
                    reason = "Violence"

                    if (chkbx_language.isChecked){
                        reason = "Violence Language"
                    }

                }

                else if (chkbx_language.isChecked){
                    reason = "Language"

                    if (chkbx_violence.isChecked){
                        reason = "Violence Language"
                    }

                }
            }
            else {
                reason = ""
                suitable = "Yes"
            }


            if(nameET.text.toString().isNotEmpty() && descptET.text.toString().isNotEmpty() && redateET.text.toString().isNotEmpty()){
                displayToast(
                    "Title = " + nameET.text.toString() + "\nOverview = " + descptET.text.toString() + "\n" + "Release date = " + redateET.text.toString() + "\nLanguage = " + language + "\nNot suitable for all ages = " + notForAll  + "\nReason: " + reason
                )


            }
            else{
                displayToast("Field cannot be empty!")
            }

            val intent = Intent(this@AddMovieActivity, MovieDetail::class.java)
            intent.putExtra("Title", name)
            intent.putExtra("Description", descpt)
            intent.putExtra("Language", language)
            intent.putExtra("Release date", releaseDate)
            intent.putExtra("Suitable", suitable)
            intent.putExtra("Reason", reason)

            startActivity(intent)

        }

    }



    fun displayToast(message:String){

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }
}
