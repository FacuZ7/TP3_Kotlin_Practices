package com.example.recyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.adapters.ContactAdapter
import com.example.recyclerview.entities.Contacto
import java.util.ArrayList

class fragmentRecyclerView : Fragment() {

    lateinit var view3: View
    lateinit var btnBack: Button
    lateinit var recycler: RecyclerView

    private var contactos : MutableList<Contacto> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view3 = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        btnBack = view3.findViewById(R.id.frg3_btn_Back)
        recycler = view3.findViewById(R.id.frg3_recycler)

        val contacto1 = Contacto(
            nombre = "Juan Pérez",
            telefono = "+1234567890",
            email = "juan.perez@example.com",
            direccion = "Calle 123, Ciudad Ejemplo",
            foto = "https://via.placeholder.com/150"
        )

        val contacto2 = Contacto(
            nombre = "María López",
            telefono = "+1987654321",
            email = "maria.lopez@example.com",
            direccion = "Avenida Principal 456, Pueblo Feliz",
            foto = "https://via.placeholder.com/150"
        )

        val contacto3 = Contacto(
            nombre = "Pedro García",
            telefono = "+1555555555",
            email = "pedro.garcia@example.com",
            direccion = "Plaza Mayor 789, Ciudad Principal",
            foto = "https://via.placeholder.com/150"
        )

        //agrego los mismos contactos varias veces para poder scrollear
        for (i in 1..10){
            contactos.add(contacto1)
            contactos.add(contacto2)
            contactos.add(contacto3)
        }

        recycler.setHasFixedSize(true) //que tenga un ancho fijo
        val linearLayoutManager = LinearLayoutManager(context) //le indico la orientación
        val contactAdapter = ContactAdapter(contactos)
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = contactAdapter


        return view3
    }

    override fun onStart() {
        super.onStart()

        btnBack.setOnClickListener{

            val action2 = fragmentRecyclerViewDirections.actionFragmentRecyclerViewToFragment1()

            view3.findNavController().navigate(action2)
        }


    }

}