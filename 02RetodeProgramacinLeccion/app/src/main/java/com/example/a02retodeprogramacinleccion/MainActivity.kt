package com.example.a02retodeprogramacinleccion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a02retodeprogramacinleccion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verificar.setOnClickListener {
            verificarAprobacion()
        }
    }

    private fun verificarAprobacion() {
        val notaStr = binding.nota.text.toString()

        if (notaStr.isNotBlank()) {
            val nota = notaStr.toFloat()

            if (nota >= 70) {
                binding.aprobacion.text = "Usted ha APROBADO el examen"
            } else {
                binding.aprobacion.text = "Usted NO ha aprobado el examen"
            }
        } else {
            binding.aprobacion.text = "Por favor ingrese una calificación"
        }
    }
}