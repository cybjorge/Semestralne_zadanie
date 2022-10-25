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


var global_pub: MutableList<Pub> = ArrayList()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val lop=ListOfPubs()
        val loader = PubDatasource()
        val jsonFile=lop.context?.let { loader.getJsonDataFromAsset(lop.context!!,"pubs.json") }
        global_pub = jsonFile?.let { PubDatasource().loadPubsFromJson(it) }!!


        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

}