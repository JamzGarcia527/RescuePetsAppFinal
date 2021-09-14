package com.jamzdeveploment.rescuepetsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jamzdeveploment.rescuepetsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // paso 1 inicializar el objeto ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // nos referimos a los objetos de la vista

        binding.button.setOnClickListener {
            val email = binding.tilEmail.text.toString()
            val password = binding.tilPassword.text.toString()
            // para realizar el debug en Logcat y tambien se ve en el RUN
            Log.i("MainActivity","OnCreate: email: $email, password: $password")
        }

    }
}