package com.example.semestralne_zadanie

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.airbnb.lottie.LottieAnimationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [animation.newInstance] factory method to
 * create an instance of this fragment.
 */
class animation : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_animation, container, false)

        val animation_view=view.findViewById<LottieAnimationView>(R.id.animation_view)
        animation_view.playAnimation()

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: animationArgs by navArgs()

        val name=args.submittedName
        val pub=args.submittedPub
        val lat=args.subLat
        val alt=args.subAlt

        view.findViewById<TextView>(R.id.submitted_name).text=name
        view.findViewById<TextView>(R.id.submitted_pub).text=pub
    }

}