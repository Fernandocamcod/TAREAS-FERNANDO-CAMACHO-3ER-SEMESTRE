package com.example.coloresfrutas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coloresfrutas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Listener para el botón
        binding.boton.setOnClickListener {
            val nombre = binding.nombrefruta.text.toString().trim()
            if (nombre.isNotEmpty()) {
                val color = obtenerColorDeFruta(nombre)
                binding.colorfruta.text = color
            } else {
                Toast.makeText(this, "Ingrese el nombre de una fruta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun obtenerColorDeFruta(nombre: String): String {
        return when (nombre.lowercase()) {
            "manzana" -> "Rojo"
            "banana" -> "Amarillo"
            "uva" -> "Morado"
            "naranja" -> "Naranja"
            "limón" -> "Verde"
            "fresa" -> "Rojo"
            "arándano" -> "Azul"
            "piña" -> "Amarillo"
            "kiwi" -> "Verde"
            "melocotón" -> "Naranja"
            "mango" -> "Naranja"
            "sandía" -> "Rojo"
            "papaya" -> "Naranja"
            "cereza" -> "Rojo"
            "pera" -> "Verde"
            "frambuesa" -> "Rojo"
            "mora" -> "Morado"
            "ciruela" -> "Morado"
            "granada" -> "Rojo"
            "mandarina" -> "Naranja"
            "pomelo" -> "Rosa"
            "guayaba" -> "Rosa"
            "lichi" -> "Rosa"
            "durazno" -> "Naranja"
            "coco" -> "Blanco"
            "melón" -> "Verde"
            "carambola" -> "Amarillo"
            "higo" -> "Morado"
            "tamarindo" -> "Marrón"
            "arándano rojo" -> "Rojo"
            else -> "Color desconocido"
        }
    }
}