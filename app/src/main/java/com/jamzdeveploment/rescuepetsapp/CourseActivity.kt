package com.jamzdeveploment.rescuepetsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        // declaracion de variables
        // var se puede reasiganr
        // val no se puede reasignar

        var edad  = 25
        edad = 73

        val identificador = 123456

        // no se puede reasignar
        // identificador = 99999

         // CONSTANTES se nombran en mayuscula y se separan con guin bajo
        //const val NUMERO_PI = 3.141

        // DATOS PRIMITIVOS
        // typo Byte, contiene un tamaño de 8bits -128 y 127

        val miByt: Byte = 1

        // tipo Short


    }
}