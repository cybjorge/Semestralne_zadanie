package com.example.semestralne_zadanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment =supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

    /*
        setContentView(R.layout.activity_main)

        val an=findViewById<com.airbnb.lottie.LottieAnimationView>(R.id.animation_view)

        an.setOnClickListener {
            an.playAnimation()
        }
        */

    }
}