package com.example.a01retodeprogramacion1leccion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var pesoEditText: EditText
    private lateinit var alturaEditText: EditText
    private lateinit var calcularButton: Button
    private lateinit var resultadoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pesoEditText = findViewById(R.id.edit1)
        alturaEditText = findViewById(R.id.edit2)
        calcularButton = findViewById(R.id.boton)
        resultadoTextView = findViewById(R.id.resultado)

        calcularButton.setOnClickListener {
            calcularIMC()
        }
    }

    private fun calcularIMC() {
        val pesoStr = pesoEditText.text.toString()
        val alturaStr = alturaEditText.text.toString()

        if (pesoStr.isNotBlank() && alturaStr.isNotBlank()) {
            val peso = pesoStr.toFloatOrNull()
            val alturaCm = alturaStr.toFloatOrNull()

            if (peso != null && alturaCm != null && alturaCm > 0) {
                val alturaM = alturaCm / 100
                val imc = peso / (alturaM * alturaM)
                val resultadoIMC = String.format("%.2f", imc)
                resultadoTextView.text = "Su IMC es: $resultadoIMC"
            } else {
                resultadoTextView.text = "Valores de peso o altura no válidos"
            }
        } else {
            resultadoTextView.text = "Por favor ingrese peso y altura"
        }
    }
}