package com.example.temperatura

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextCelsius: EditText
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCelsius = findViewById(R.id.edit1)
        textViewResultado = findViewById(R.id.resultado)
        val buttonConvertir: Button = findViewById(R.id.boton)

        buttonConvertir.setOnClickListener {
            convertirTemperatura()
        }
    }

    fun convertirTemperatura() {

        val inputCelsius = editTextCelsius.text.toString()

        if (inputCelsius.isNotEmpty()) {

            val celsius = inputCelsius.toDouble()

            val fahrenheit = celsius * 9 / 5 + 32

            textViewResultado.text = String.format("%.2f", fahrenheit) + " °F"
        } else {
            textViewResultado.text = "Ingrese un valor válido"
        }
    }
}
