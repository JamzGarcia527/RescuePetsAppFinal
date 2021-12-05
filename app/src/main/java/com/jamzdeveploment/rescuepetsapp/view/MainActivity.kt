package com.jamzdeveploment.rescuepetsapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import coil.api.load
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jamzdeveploment.rescuepetsapp.ExampleActivity
import com.jamzdeveploment.rescuepetsapp.R
import com.jamzdeveploment.rescuepetsapp.SignInActivity
import com.jamzdeveploment.rescuepetsapp.WebServiceExampleActivity
import com.jamzdeveploment.rescuepetsapp.databinding.ActivityMainBinding
import com.jamzdeveploment.rescuepetsapp.entities.UserDataCollectionItem
import com.jamzdeveploment.rescuepetsapp.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    @Inject
    private lateinit var presenter: MainPresenter

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

            //it.setLogo(R.drawable.logo)
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

        // intento # 2 conexion con web service

        binding.button5.setOnClickListener {
            val intent = Intent(this, WebServiceExampleActivity::class.java )
            startActivity(intent)
            Toast.makeText(baseContext, "Redirect to Web Service Activity xD",
                Toast.LENGTH_SHORT).show()
        }

        // intento # 1 conexion con web service con retrofit2, Fail al llamar el servicio se cierra la App

        binding.btnRest.setOnClickListener {
            Toast.makeText(
                baseContext, "Dio clic en web services",
                Toast.LENGTH_SHORT
            ).show()
           // callServiceGetUsers()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun callServiceGetUsers() {
        presenter.listUsers()
    }

    override fun showResult(result: List<UserDataCollectionItem>) {
        Log.d("Success Response", result.toString())
        Toast.makeText(this, "Success Response", Toast.LENGTH_LONG).show()
    }

    override fun errorResult(t: String) {
        Toast.makeText(this, "Error Response", Toast.LENGTH_LONG).show()
    }


}





