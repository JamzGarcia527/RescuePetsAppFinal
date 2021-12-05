package com.jamzdeveploment.rescuepetsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.jamzdeveploment.rescuepetsapp.databinding.ActivityWebServiceExampleBinding

class WebServiceExampleActivity : AppCompatActivity() {

    // delcaramos la variable donde llamamos a la Activity con binding
    private lateinit var binding: ActivityWebServiceExampleBinding

    // creamos nuestro adapatador para traer la lista de las razas mediante el web service
    val AdapterRazas : AdapterRazas = AdapterRazas()

    private lateinit var context: Context

    //onCreate es la funcion principal del programa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* en la variable binding almacenamos el cargue inicial de la Activiity en la que estamos,
        * en este caso ExampleActivity
        * y usamos el metodo inflate para generar la vista de Activity
        * por ultimo con el metodo setContentView cargamos la Actividty con (bindind.root)
        */
        binding = ActivityWebServiceExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // funcion para cargar las diferentes razas desde la API
        // cargarListaRazas()
    }
}