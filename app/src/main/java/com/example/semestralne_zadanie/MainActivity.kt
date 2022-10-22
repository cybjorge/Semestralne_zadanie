package com.example.semestralne_zadanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val an=findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.animation_view)

        an.setOnClickListener {
            an.playAnimation()
        }

    }
}