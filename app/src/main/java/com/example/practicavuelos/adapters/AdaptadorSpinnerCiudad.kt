package com.example.practicavuelos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.practicavuelos.R
import com.example.practicavuelos.model.Ciudad

class AdaptadorSpinnerCiudad(private var lista: ArrayList<Ciudad>, private var contexto: Context) : BaseAdapter() {

    override fun getCount(): Int = lista.size

    override fun getItem(position: Int): Ciudad = lista[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vista: View
        val holder: ViewHolder

        if (convertView == null) {
            vista = LayoutInflater.from(contexto).inflate(R.layout.item_ciudad, parent, false)
            holder = ViewHolder(vista)
            vista.tag = holder
        } else {
            vista = convertView
            holder = vista.tag as ViewHolder
        }

        val ciudad = getItem(position)
        holder.textoCiudad.text = ciudad.nombre
        holder.imagenCiudad.setImageResource(ciudad.imagen)

        return vista
    }

    private class ViewHolder(vista: View) {
        val textoCiudad: TextView = vista.findViewById(R.id.texto_ciudad)
        val imagenCiudad: ImageView = vista.findViewById(R.id.imagen_ciudad)
    }
}
