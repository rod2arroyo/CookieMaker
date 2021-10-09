package com.example.cookiemaker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.*
import com.example.cookiemaker.adapter.ingredientsAdapter
import com.example.cookiemaker.adapter.recetaingredientesAdapter
import com.example.cookiemaker.adapter.viewrecipecookieAdapter

class ViewRecipe : Fragment() {
    lateinit var ACTIVITY : MainActivity
    interface OnMenuClicked{
        fun OnClick(menuName: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ACTIVITY = context as MainActivity
        return inflater.inflate(R.layout.fragment_verreceta,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var textoop = view.findViewById<TextView>(R.id.nombreseleccionado)
        textoop?.text = nombregalleta



        val recycleringredients = view.findViewById<RecyclerView>(R.id.recetaseleccionada)

        recycleringredients.adapter = viewrecipecookieAdapter(listaselecciongalleta)

    }

}