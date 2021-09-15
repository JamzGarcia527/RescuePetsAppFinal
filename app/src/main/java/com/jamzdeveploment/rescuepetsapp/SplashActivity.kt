package com.jamzdeveploment.rescuepetsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(3000)

        super.onCreate(savedInstanceState)
        startActivity(Intent(this,SignInActivity::class.java))
    }
}