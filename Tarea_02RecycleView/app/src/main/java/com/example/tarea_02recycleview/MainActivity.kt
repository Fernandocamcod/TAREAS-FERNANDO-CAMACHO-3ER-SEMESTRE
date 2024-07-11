package com.example.tarea_02recycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea_02recycleview.Persona
import com.example.tarea_02recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var personaAdapter: PersonaAdapter
    private lateinit var personaList: MutableList<Persona>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personaList = mutableListOf(
            Persona(1, "Juan Pérez", 32, "Masculino", 250),
            Persona(2, "María González", 28, "Femenino", 320),
            Persona(3, "Carlos Martínez", 40, "Masculino", 400),
            Persona(4, "Ana López", 35, "Femenino", 280),
            Persona(5, "Pedro García", 45, "Masculino", 350),
            Persona(6, "Laura Rodríguez", 30, "Femenino", 300),
            Persona(7, "Diego Hernández", 38, "Masculino", 380),
            Persona(8, "Sofía Díaz", 25, "Femenino", 270),
            Persona(9, "Javier Sánchez", 42, "Masculino", 420),
            Persona(10, "Valeria Ramírez", 29, "Femenino", 310),
            Persona(11, "Miguel Torres", 36, "Masculino", 360),
            Persona(12, "Elena Gómez", 31, "Femenino", 290),
            Persona(13, "Ricardo Vargas", 39, "Masculino", 390),
            Persona(14, "Paula Muñoz", 27, "Femenino", 260),
            Persona(15, "Gabriel Flores", 33, "Masculino", 330),
            Persona(16, "Daniela Chávez", 34, "Femenino", 340),
            Persona(17, "Fernando Medina", 37, "Masculino", 370),
            Persona(18, "Isabel Jiménez", 26, "Femenino", 280),
            Persona(19, "Mateo Rojas", 41, "Masculino", 410),
            Persona(20, "Camila Herrera", 28, "Femenino", 320)
        )
        personaAdapter = PersonaAdapter(personaList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = personaAdapter
    }
}