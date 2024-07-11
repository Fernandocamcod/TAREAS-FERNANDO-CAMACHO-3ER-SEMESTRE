package com.example.a03retodeprogramacionleccion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notaEditText: EditText = findViewById(R.id.nota)
        val verificarButton: Button = findViewById(R.id.boton)
        val resultadoTextView: TextView = findViewById(R.id.verificado)

        verificarButton.setOnClickListener {
            val notaStr = notaEditText.text.toString()
            if (notaStr.isNotEmpty()) {
                val nota = notaStr.toDouble()
                val resultado = if (nota >= 70) "Aprobado" else "Reprobado"
                resultadoTextView.text = "Resultado: $resultado"
            } else {
                resultadoTextView.text = "Por favor, ingrese una nota válida."
            }
        }
    }
}