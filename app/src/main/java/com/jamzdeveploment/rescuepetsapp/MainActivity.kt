package com.jamzdeveploment.rescuepetsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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


        binding.oliveSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.imageView3.setImageResource(R.drawable.olive_branch)
            }else{
                binding.imageView3.setImageResource(R.drawable.logo)
            }

        }

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

            singOut()
        }

    }

    private fun singOut(){
        Firebase.auth.signOut()
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    fun showMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}