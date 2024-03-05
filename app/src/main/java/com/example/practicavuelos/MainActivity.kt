package com.example.practicavuelos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicavuelos.adapters.AdaptadorSpinnerCiudad
import com.example.practicavuelos.adapters.ViajeAdapter
import com.example.practicavuelos.data.DataSet
import com.example.practicavuelos.databinding.ActivityMainBinding
import com.example.practicavuelos.model.Viaje
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var horaSeleccionada: String = ""
    private var fechaSeleccionada: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.textoHoraIda.setOnClickListener {
            mostrarDialogoHora()
            binding.textoHoraIda.text = horaSeleccionada
        }
        binding.textoHoraVuelta.setOnClickListener {
            mostrarDialogoHora()
            binding.textoHoraVuelta.text = horaSeleccionada
        }
        binding.textoFechaIda.setOnClickListener {
            mostrarDialogoFecha()
            binding.textoFechaIda.text = fechaSeleccionada
        }
        binding.textoFechaVuelta.setOnClickListener {
            mostrarDialogoFecha()
            binding.textoFechaVuelta.text = fechaSeleccionada
        }

        binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
            binding.spinnerDestino.isEnabled = !isChecked
            binding.textoHoraVuelta.isEnabled = !isChecked
            binding.textoFechaVuelta.isEnabled = !isChecked
        }

        val ciudades = DataSet.obtenerListaCompleta()
        val adaptador = AdaptadorSpinnerCiudad(ciudades, this)
        binding.spinnerOrigen.adapter = adaptador
        binding.spinnerDestino.adapter = adaptador


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val viajeAdapter = ViajeAdapter(arrayListOf())
        binding.recyclerView.adapter = viajeAdapter


        binding.botonAgregar.setOnClickListener {
            viajeAdapter.agregarViaje(Viaje(binding.spinnerOrigen.selectedItem.toString(),binding.spinnerDestino.selectedItem.toString(),binding.textoFechaIda.text.toString(),binding.textoHoraIda.text.toString(),binding.textoFechaVuelta.text.toString(),binding.textoHoraVuelta.text.toString()))
        }
    }


    private fun mostrarDialogoHora() {
        val calendar = Calendar.getInstance()
        val hora = calendar.get(Calendar.HOUR)
        val minuto = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, hourOfDay, minute ->
            val horaFormato12 = if (hourOfDay > 12) hourOfDay - 12 else hourOfDay
            horaSeleccionada = "$horaFormato12:$minute ${if (hourOfDay >= 12) "PM" else "AM"}"
        }, hora, minuto, false)

        timePickerDialog.show()
    }

    private fun mostrarDialogoFecha() {
        val calendar = Calendar.getInstance()
        val año = calendar.get(Calendar.YEAR)
        val mes = calendar.get(Calendar.MONTH)
        val dia = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            fechaSeleccionada = "$dayOfMonth/${month + 1}/$year"
        }, año, mes, dia)

        datePickerDialog.show()
    }
}