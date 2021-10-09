package com.example.cookiemaker.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.*
import com.example.cookiemaker.adapter.ingredientsAdapter
import pe.edu.ulima.pm.ulgamestore.model.Ingrediente

class IngredientFragment : Fragment(){
    lateinit var ACTIVITY : MainActivity
    interface OnMenuClicked{
        fun OnClick(menuName: String)
    }

    private var listener: RecipesFragment.OnMenuClicked? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as RecipesFragment.OnMenuClicked
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ACTIVITY = context as MainActivity
        return inflater.inflate(R.layout.fragment_ingredient,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycleringredients = view.findViewById<RecyclerView>(R.id.recycleringredients)
        //recycleringredients.adapter = ingredientsAdapter(ACTIVITY.recetasManager.getIngredientes())
        recycleringredients.adapter = ingredientsAdapter(listanueva
        ){ ingrediente: Ingrediente ->
            Log.i("ingredientesee", ingrediente.nombre)
            listaactualreceta.add(ingrediente)
            listanueva.remove(ingrediente)
            listener?.OnClick("createRecipe")
        }

    }

}