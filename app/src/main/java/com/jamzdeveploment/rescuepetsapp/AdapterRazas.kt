package com.jamzdeveploment.rescuepetsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jamzdeveploment.rescuepetsapp.databinding.PatronlistaBinding

class AdapterRazas : RecyclerView.Adapter<AdapterRazas.MyViewHolder>() {
    var Razas : MutableList<listadoprin> = ArrayList()
    lateinit var context : Context

    class MyViewHolder(val binding: PatronlistaBinding) : RecyclerView.ViewHolder(binding.root)

    fun AdapterRazas(Raza: MutableList<listadoprin>, context: Context){
        this.Razas = Raza
        this.context = context

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = Razas.get(position)
        holder.binding.textraza.text = item.razas

        holder.binding.nombreraza.setOnClickListener {
            Toast.makeText(context, "Raza - > "+ item.razas.toString() , Toast.LENGTH_SHORT).show()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(PatronlistaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
         return Razas.size
    }

}