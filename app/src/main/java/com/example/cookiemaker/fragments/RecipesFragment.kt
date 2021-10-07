package com.example.cookiemaker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.R
import com.example.cookiemaker.adapter.RecipeListAdapter
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class RecipesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rviRecipes = view.findViewById<RecyclerView>(R.id.rviRecipes)
        rviRecipes.adapter = RecipeListAdapter(RecetasManager().getRecetas())

        val btnAgregar = view.findViewById<Button>(R.id.btnAgregar)
        btnAgregar.setOnClickListener{ _ : View ->

        }
    }
}