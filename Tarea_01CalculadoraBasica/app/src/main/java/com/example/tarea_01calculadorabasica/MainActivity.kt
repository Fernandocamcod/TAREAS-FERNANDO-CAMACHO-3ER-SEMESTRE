package com.example.tarea_01calculadorabasica

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea_01calculadorabasica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calcular.setOnClickListener {

            val numero1 = binding.numero1.text.toString().toFloat()
            val numero2 = binding.numero2.text.toString().toFloat()

            val resultado = when (binding.grupo.checkedRadioButtonId) {
                R.id.sumar -> numero1 + numero2
                R.id.restar -> numero1 - numero2
                R.id.multi -> numero1 * numero2
                R.id.dividir -> if (numero2 != 0f) numero1 / numero2 else Float.NaN
                else -> Float.NaN
            }

            binding.resultado.setText(resultado.toString())
        }
    }
}
