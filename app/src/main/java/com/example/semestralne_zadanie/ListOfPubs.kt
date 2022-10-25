package com.example.semestralne_zadanie

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.semestralne_zadanie.adapter.ItemAdapter
import com.example.semestralne_zadanie.data.PubDatasource
import com.example.semestralne_zadanie.model.Pub
import java.util.logging.Logger.global

class ListOfPubs : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list_of_pubs, container, false)

        val loader = PubDatasource()
        val jsonFile=this.context?.let { loader.getJsonDataFromAsset(it,"pubs.json") }
        global_pub = jsonFile?.let { PubDatasource().loadPubsFromJson(it) }!!


        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView?.adapter=ItemAdapter(this, global_pub)
        recyclerView?.setHasFixedSize(true)

        return view
    }


}