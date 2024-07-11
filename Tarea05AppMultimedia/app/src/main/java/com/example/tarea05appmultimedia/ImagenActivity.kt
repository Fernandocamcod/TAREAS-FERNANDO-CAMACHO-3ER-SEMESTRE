package com.example.tarea05appmultimedia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea05appmultimedia.databinding.ActivityImagenBinding

class ImagenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImagenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonimagen2.setOnClickListener { seleccionarImagen()}
    }
    val register=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){
            val intent = it.data
            binding.aqui.setImageURI(intent?.data)
        }
    }
    private fun seleccionarImagen(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type="image/*"
        register.launch(intent)
    }
}