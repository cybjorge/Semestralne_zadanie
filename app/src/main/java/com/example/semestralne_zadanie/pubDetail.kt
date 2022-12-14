package com.example.semestralne_zadanie

import android.content.ClipData
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.semestralne_zadanie.adapter.ItemAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [pubDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class pubDetail : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pub_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: pubDetailArgs by navArgs()

        val detail_p_name=args.detailPName
        val detail_p_hours=args.detailPTime
        val detail_p_website=args.detailPContact

        val i_id = args.iId
        view.findViewById<TextView>(R.id.detail_pub_name).text=detail_p_name
        view.findViewById<TextView>(R.id.detail_pub_hours).text=detail_p_hours
        if (detail_p_website!="Neni web"){
            view.findViewById<Button>(R.id.detail_show_on_map).text=detail_p_website
            view.findViewById<Button>(R.id.detail_show_on_map).setOnClickListener {
                val uri= detail_p_website
                val intent= Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                requireContext().startActivity(intent)
            }
        }
        else{
            view.findViewById<Button>(R.id.detail_show_on_map).text=detail_p_website
        }



        view.findViewById<Button>(R.id.delete).setOnClickListener {
            MySingleton.pubs.removeAt(i_id.toInt())
            view.findNavController().navigate(R.id.listOfPubs)
        }



    }
}