package com.example.cuentabancaria

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewValor: TextView
    private lateinit var editTextDepositar: EditText
    private lateinit var editTextRetirar: EditText
    private lateinit var cuentaBancaria: CuentaBancaria

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cuentaBancaria = CuentaBancaria("2100457961", "Fernando Camacho", 500.00)

        textViewValor = findViewById(R.id.textViewValor)
        editTextDepositar = findViewById(R.id.editTextDepositar)
        editTextRetirar = findViewById(R.id.editTextRetirar)
        val buttonDepositar: Button = findViewById(R.id.buttonDepositar)
        val buttonRetirar: Button = findViewById(R.id.buttonRetirar)


        buttonDepositar.setOnClickListener {
            val montoDepositar = editTextDepositar.text.toString().toDoubleOrNull()
            if (montoDepositar != null) {
                cuentaBancaria.depositar(montoDepositar)
                actualizarSaldo()
                Toast.makeText(this, "Depósito realizado. Nuevo saldo: ${cuentaBancaria.saldo}", Toast.LENGTH_SHORT).show()
                editTextDepositar.text.clear()
            } else {
                editTextDepositar.error = "Ingrese un monto válido"
            }
        }

        buttonRetirar.setOnClickListener {
            val montoRetirar = editTextRetirar.text.toString().toDoubleOrNull()
            if (montoRetirar != null) {
                if (cuentaBancaria.retirar(montoRetirar)) {
                    actualizarSaldo()
                    Toast.makeText(this, "Retiro realizado. Nuevo saldo: ${cuentaBancaria.saldo}", Toast.LENGTH_SHORT).show()
                    editTextRetirar.text.clear()
                } else {
                    editTextRetirar.error = "Saldo insuficiente"
                    Toast.makeText(this, "Saldo insuficiente para realizar el retiro.", Toast.LENGTH_SHORT).show()
                }
            } else {
                editTextRetirar.error = "Ingrese un monto válido"
            }
        }

        actualizarSaldo()
    }

    private fun actualizarSaldo() {
        textViewValor.text = String.format("$%.2f", cuentaBancaria.consultarSaldo())
    }
}