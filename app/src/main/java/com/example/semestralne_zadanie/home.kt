package com.example.semestralne_zadanie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val arg_meno = "p1"
private const val arg_pub = "p2"
private const val arg_lat = "p3"
private const val arg_alt= "p4"
/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */
class home : Fragment(){
    // TODO: Rename and change types of parameters
    private var name: String? = null
    private var pub_name: String? = null
    private var latitude: String? = null
    private var altitude: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            name = it.getString(arg_meno)
            pub_name = it.getString(arg_pub)
            latitude = it.getString(arg_lat)
            altitude = it.getString(arg_alt)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val bttn = view.findViewById<Button>(R.id.submit_button)
        bttn?.setOnClickListener{
            @NonNull
            val filled_name_et= view.findViewById<EditText>(R.id.name).text.toString()
            @NonNull
            val filled_pub_et= view.findViewById<EditText>(R.id.pub_name).text.toString()
            @NonNull
            val filled_lat_et= view.findViewById<EditText>(R.id.latitude).text.toString()
            @NonNull
            val filled_alt_et= view.findViewById<EditText>(R.id.altitude).text.toString()


            val action=homeDirections.actionHome2ToAnimation(filled_name_et,filled_pub_et,filled_lat_et,filled_alt_et)
            view.findNavController().navigate(action)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(name: String, pub_name: String, lat: String, alt: String) =
            home().apply {
                arguments = Bundle().apply {
                    putString(arg_meno, name)
                    putString(arg_pub, pub_name)
                    putString(arg_lat, lat)
                    putString(arg_alt, alt)
                }
            }
    }
}