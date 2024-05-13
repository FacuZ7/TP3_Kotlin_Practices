package com.example.recyclerview.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R


class ContactoHolder(v: View) : RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setName(name: String?) {
        val txt: TextView = view.findViewById(R.id.contactoitem_nombre)
        txt.text = name
    }

    fun setTelefono(tel: String?){
        val txt: TextView = view.findViewById(R.id.contactoitem_telefono)
        txt.text = tel
    }

    fun setEmail(email: String?){
        val txt: TextView = view.findViewById(R.id.contactoitem_email)
        txt.text = email
    }

    fun setAvatar(url: String){
        /*val img: ImageView = view.findViewById(R.id.imgAvatar)
        img.setImageResource(url)*/
    }

    fun getCardLayout (): View {
        return view.findViewById(R.id.contactoitem_cardview)
    }
}