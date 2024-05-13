package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.navigation.R

class fragment1 : Fragment() {

    lateinit var view1: View
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_fragment1, container, false)
        btnNext = view1.findViewById(R.id.frg1_btn_Siguiente)

        btnNext.setOnClickListener{

            val action2 = fragment1Directions.actionFragment1ToFragment2()

            view1.findNavController().navigate(action2)
        }
        return view1
    }


}