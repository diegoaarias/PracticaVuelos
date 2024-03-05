package com.example.practicavuelos.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicavuelos.R
import com.example.practicavuelos.data.DataSet
import com.example.practicavuelos.model.Viaje

class ViajeAdapter(private val viajes: ArrayList<Viaje>) :
    RecyclerView.Adapter<ViajeAdapter.ViajeViewHolder>() {

    class ViajeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val origen_destino: TextView = itemView.findViewById(R.id.origen_destino)
        val imagen: ImageView = itemView.findViewById(R.id.imagen_ciudad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViajeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViajeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViajeViewHolder, position: Int) {
        val viaje = viajes[position]
        holder.origen_destino.text = "${viaje.origen} - ${viaje.destino}"
        val imagenRecurso = DataSet.obtenerImagenCiudad(viaje.destino)
        if (imagenRecurso != null) {
            holder.imagen.setImageResource(imagenRecurso)
        } else {
        }
    }

    override fun getItemCount() = viajes.size

    fun agregarViaje(viaje: Viaje) {
        viajes.add(viaje)
        notifyItemInserted(viajes.size - 1)
    }
}
