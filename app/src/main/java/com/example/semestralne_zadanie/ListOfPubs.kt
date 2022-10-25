package com.example.semestralne_zadanie

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.semestralne_zadanie.adapter.ItemAdapter
import com.example.semestralne_zadanie.data.PubDatasource
import com.example.semestralne_zadanie.model.Pub

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListOfPubs.newInstance] factory method to
 * create an instance of this fragment.
 */
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

        var allPubs : MutableList<Pub> = ArrayList()
        allPubs = jsonFile?.let { PubDatasource().loadPubsFromJson(it) }!!

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView?.adapter=ItemAdapter(this, allPubs)
        recyclerView?.setHasFixedSize(true)

        return view
    }


}