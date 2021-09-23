package com.jamzdeveploment.rescuepetsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jamzdeveploment.rescuepetsapp.databinding.ActivityExampleBinding

class ExampleActivity : AppCompatActivity() {

    // delcaramos la variable donde llamamos a la Acrivity con binding
    private lateinit var binding: ActivityExampleBinding

    //onCreate es la funcion principal del programa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* en la variable binding almacenamos el cargue inicial de la Activiity en la que estamos,
        * en este caso ExampleActivity
        * y usamos el metodo inflate para generar la vista de Activity
        * por ultimo con el metodo setContentView cargamos la Actividty con (bindind.root)
        */
        binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            // metodo usado para volver a la MainActivity
            returnActivity()
        }


    }
    // funcion para volver a la MainActivity, luego de dar clic en el boton volver
    private fun returnActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}