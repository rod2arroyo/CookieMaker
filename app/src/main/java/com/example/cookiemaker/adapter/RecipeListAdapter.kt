package com.example.cookiemaker.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import pe.edu.ulima.pm.ulgamestore.model.Receta
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.R

class RecipeListAdapter(private val recipeList : List<Receta>) :
    RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {
        class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val imgRecipe : ImageView
            val txtUser : TextView
            val txtRecipeName : TextView

            init{
                imgRecipe = view.findViewById(R.id.imgRecipe)
                txtUser = view.findViewById(R.id.txtUser)
                txtRecipeName = view.findViewById(R.id.txtRecipeName)
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipes, parent,false)

        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtUser.text = recipeList[position].usuario
        holder.txtRecipeName.text = recipeList[position].nombre
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

}