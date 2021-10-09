package com.example.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.*
import com.example.cookiemaker.adapter.RecipeListAdapter
import pe.edu.ulima.pm.ulgamestore.model.Receta
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class RecipesFragment: Fragment() {
    lateinit var ACTIVITY : MainActivity
    interface OnMenuClicked{
        fun OnClick(menuName: String)
    }

    private var listener: OnMenuClicked? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as OnMenuClicked
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ACTIVITY = context as MainActivity
        return inflater.inflate(R.layout.fragment_recipes,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rviRecipes = view.findViewById<RecyclerView>(R.id.rviRecipes)
        //rviRecipes.adapter = RecipeListAdapter(ACTIVITY.recetasManager.getRecetas()
        rviRecipes.adapter = RecipeListAdapter(recetasManagerop.getRecetas()
        ) { receta: Receta ->


            idgalleta=receta.id
            listaselecciongalleta = receta.ingredientes
            nombregalleta = receta.nombre



            for(i in 0..(receta.ingredientes.size-1)){
                Log.i("ingredi--->",receta.ingredientes[i].nombre)
            }
            Log.i("RecetaFragment", receta.id.toString())

            listener?.OnClick("verreceta")

        }

        val btnAgregar = view.findViewById<Button>(R.id.btnAgregar)
        btnAgregar.setOnClickListener{ _ : View ->
          //  listanueva = recetasManagerop.getIngredientes()
            listanueva.addAll(recetasManagerop.getIngredientes())

            for (i in 0..(recetasManagerop.getIngredientes().size-1)){
                println("listanueva graneeeeeeeee..->"+ recetasManagerop.getIngredientes()[i].nombre)
            }

            listener?.OnClick("createRecipe")
        }
    }
}