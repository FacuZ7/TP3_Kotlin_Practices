package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.navigation.R

class fragment2 : Fragment() {

    lateinit var view2: View
    lateinit var btnPrev: Button
    lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view2 = inflater.inflate(R.layout.fragment_fragment2, container, false)
        btnPrev = view2.findViewById(R.id.frg2_btn_Anterior)
        title = view2.findViewById(R.id.frg2_txt)


        return view2
    }

    override fun onStart() {
        super.onStart()

        val parameter = fragment2Args.fromBundle(requireArguments())
        title.text = parameter.Text

        btnPrev.setOnClickListener{

            val action2 = fragment2Directions.actionFragment2ToFragment1()

            view2.findNavController().navigate(action2)
        }
    }

}