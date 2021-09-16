package com.jamzdeveploment.rescuepetsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.jamzdeveploment.rescuepetsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

       ////Thread.sleep(3000)
        //setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)

        // paso 1 inicializar el objeto ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // nos referimos a los objetos de la vista

        binding.button.setOnClickListener {
            val email = binding.tilEmail.text.toString()
            val password = binding.tilPassword.text.toString()
            val message = getString(R.string.message_text, email, password)

            Snackbar.make(it, "Mensaje Snack\uD83E\uDDD0", Snackbar.LENGTH_INDEFINITE)
                .setAction("Mostrar Info"){showMessage(message)}
                .show()


            // para realizar el debug en Logcat y tambien se ve en el RUN
            Log.i("MainActivity",message)
        }
    }

    fun showMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}