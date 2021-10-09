package com.example.cookiemaker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.R
import pe.edu.ulima.pm.ulgamestore.model.Ingrediente

class viewrecipecookieAdapter(private val recipeList : List<Ingrediente>) :
    RecyclerView.Adapter<viewrecipecookieAdapter.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

            val ingrediente: TextView

            init {
                ingrediente = view.findViewById(R.id.textViewingredient)
            }

        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ingrediente, parent,false)

            val viewHolder = ViewHolder(view)
            return viewHolder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //holder.txtUser.text = recipeList[position].usuario
            // holder.txtRecipeName.text = recipeList[position].nombre
            holder.ingrediente.text = recipeList[position].nombre
        }

        override fun getItemCount(): Int {
            return recipeList.size
        }


    }