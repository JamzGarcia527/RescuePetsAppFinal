package com.jamzdeveploment.rescuepetsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import coil.api.load
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jamzdeveploment.rescuepetsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // paso 1 inicializar el objeto ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayUseLogoEnabled(true)
            // aqui va el logo con el ejercicio del profesor pendiente !!

            it.setLogo(R.drawable.logo)
        }

        binding.oliveSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.imageView3.setImageResource(R.drawable.ic_olive_branch_vector)
            } else {
                binding.imageView3.setImageResource(R.drawable.logo)
            }

        }

       // binding.switch1.setOnCheckedChangeListener { _, isChecked ->
        //    if (isChecked) {

          //      binding.imageView4.setImageResource(R.drawable.ic_olive_branch_vector)
          //  } else {
          //      binding.imageView4.setImageResource(R.drawable.logo)
          //  }

        // }

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                binding.imageView4.load("https://cdn.iconscout.com/icon/premium/png-256-thumb/url-14-650251.png")
            else
                binding.imageView4.load("https://cdn.iconscout.com/icon/premium/png-256-thumb/url-1699163-1449670.png")
        }

        // nos referimos a los objetos de la vista
        binding.button.setOnClickListener {
            val email = binding.tilEmail.text.toString()
            val password = binding.tilPassword.text.toString()
            val message = getString(R.string.message_text, email, password)
            Snackbar.make(it, "Mensaje Snack\uD83E\uDDD0", Snackbar.LENGTH_INDEFINITE)
                .setAction("Mostrar Info") { showMessage(message) }
                .show()
            // para realizar el debug en Logcat y tambien se ve en el RUN
            Log.i("MainActivity", message)
        }

        // programamos el evento salir
        binding.button2.setOnClickListener {
            Toast.makeText(
                baseContext, "Gracias por usar nuestra App, Buen Día.",
                Toast.LENGTH_SHORT
            ).show()
             singOut()
        }

        // programamos el envio a otra activity

        binding.button3.setOnClickListener {
            val intent = Intent(this, ExampleActivity::class.java)
            startActivity(intent)
            Toast.makeText(baseContext, "Redirect to Example Activity xD",
                Toast.LENGTH_SHORT).show()
        }

    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun singOut() {
        Firebase.auth.signOut()
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}




