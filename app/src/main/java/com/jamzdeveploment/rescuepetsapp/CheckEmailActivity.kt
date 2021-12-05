package com.jamzdeveploment.rescuepetsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.jamzdeveploment.rescuepetsapp.databinding.ActivityCheckEmailBinding
import com.jamzdeveploment.rescuepetsapp.view.MainActivity

class CheckEmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckEmailBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        val user = auth.currentUser

        binding.veficateEmailAppCompatButton.setOnClickListener {
            val profileUpdates = userProfileChangeRequest {
            }
            user!!.updateProfile(profileUpdates)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        if (user.isEmailVerified) {
                            val intent = Intent(this, MainActivity::class.java)
                            this.startActivity(intent)
                        } else {
                            Toast.makeText(this, "Por favor verifica tu correo.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                }

        }

        binding.signOutImageView.setOnClickListener {
            signOut()
        }


    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            if (currentUser.isEmailVerified){
                reload()
            }else{
                sendEmadilVeriification()
            }
        }
    }

    private fun sendEmadilVeriification(){
        val user = auth.currentUser
        user!!.sendEmailVerification().addOnCompleteListener(this){  task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Se envio un correo de verificación", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun reload(){
        val intent = Intent( this, MainActivity::class.java)
        this.startActivity((intent))
    }

    private  fun signOut(){
        Firebase.auth.signOut()
        val intent = Intent(this, SignInActivity::class.java)
        this.startActivity(intent)
    }
}