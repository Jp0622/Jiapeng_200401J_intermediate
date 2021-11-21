package com.example.jiapeng_200401j_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rating.*

class RatingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        rating_bar.rating = 2.5f
        rating_bar.stepSize = .5f

        rating_bar.setOnRatingBarChangeListener{rating_bar, rating, fromUser ->
            Toast.makeText(this,"Rating, $rating", Toast.LENGTH_SHORT).show()
        }
    }
}