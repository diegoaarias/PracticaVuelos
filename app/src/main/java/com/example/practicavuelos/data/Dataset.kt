package com.example.practicavuelos.data

import com.example.practicavuelos.R
import com.example.practicavuelos.model.Ciudad

class DataSet {
    companion object{
        val listaCiudades = ArrayList<Ciudad>()
        fun obtenerListaCompleta(): ArrayList<Ciudad> {

            listaCiudades.add(Ciudad("Nueva York",R.drawable.newyork))
            listaCiudades.add(Ciudad("San Francisco",R.drawable.sanf))
            listaCiudades.add(Ciudad("Los Ángeles",R.drawable.la))
            listaCiudades.add(Ciudad("Roma",R.drawable.roma))
            listaCiudades.add(Ciudad("Florencia",R.drawable.florencia))
            listaCiudades.add(Ciudad("Barcelona",R.drawable.bcn))
            listaCiudades.add(Ciudad("Madrid",R.drawable.madrid))
            listaCiudades.add(Ciudad("París",R.drawable.paris))
            listaCiudades.add(Ciudad("Londres",R.drawable.london))
            
            return listaCiudades
        }

        fun obtenerImagenCiudad(nombreCiudad: String): Int? {
            for (ciudad in listaCiudades) {
                if (ciudad.nombre == nombreCiudad) {
                    return ciudad.imagen
                }
            }
            return null
        }
    }
}