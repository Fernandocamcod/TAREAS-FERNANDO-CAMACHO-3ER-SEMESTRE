package com.example.signonumero

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {
    private lateinit var titulo: TextView
    private lateinit var numero: EditText
    private lateinit var evaluar: AppCompatButton
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titulo = findViewById(R.id.titulo)
        numero = findViewById(R.id.numero)
        evaluar = findViewById(R.id.evaluar)
        resultado = findViewById(R.id.resultado)

        evaluar.setOnClickListener {
            val numeroStr = numero.text.toString().trim()

            if (numeroStr.isEmpty()) {
                resultado.text = "Por favor, ingrese un número."
            } else {
                val numero = numeroStr.toDouble()

                when {
                    numero > 0 -> resultado.text = "El número es positivo."
                    numero < 0 -> resultado.text = "El número es negativo."
                    else -> resultado.text = "El número es cero."
                }
            }
        }
    }
}