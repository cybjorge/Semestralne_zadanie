package com.example.semestralne_zadanie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.semestralne_zadanie.data.PubDatasource
import com.example.semestralne_zadanie.model.AllPubs
import com.example.semestralne_zadanie.model.Pub

object MySingleton{
    lateinit var pubs: MutableList<Pub>
}

//var global_pub: MutableList<Pub> = ArrayList()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loader = PubDatasource()
        val jsonFile=  loader.getJsonDataFromAsset(applicationContext,"pubs.json")
        val list_of_pubs = jsonFile?.let { PubDatasource().loadPubsFromJson(it) }!!

        MySingleton.pubs= list_of_pubs
        System.out.println("kokot")

        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

}