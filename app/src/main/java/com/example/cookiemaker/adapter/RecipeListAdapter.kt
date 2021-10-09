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
import kotlin.random.Random

val imagenes = arrayOf(R.drawable.galleta1,R.drawable.galleta2,R.drawable.galleta3,R.drawable.galleta4)

class RecipeListAdapter(
    private val recipeList : List<Receta>,
    private val listener : (Receta) -> Unit) :
    RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {
        class ViewHolder(view : View, val listener:(Receta) -> Unit, val recipeList : List<Receta> ) : RecyclerView.ViewHolder(view),View.OnClickListener {
            val imgRecipe : ImageView
            val txtUser : TextView
            val txtRecipeName : TextView

            init{
                imgRecipe = view.findViewById(R.id.imgRecipe)
                txtUser = view.findViewById(R.id.txtUser)
                txtRecipeName = view.findViewById(R.id.txtRecipeName)
                view.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                listener(recipeList[adapterPosition])
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipes, parent,false)

        val viewHolder = ViewHolder(view,listener,recipeList)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtUser.text = recipeList[position].usuario
        holder.txtRecipeName.text = recipeList[position].nombre
        val random  = Random.nextInt(0,3)
        holder.imgRecipe.setImageResource(imagenes[random])
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

}