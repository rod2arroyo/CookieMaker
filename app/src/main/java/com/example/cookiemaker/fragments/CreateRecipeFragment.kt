package com.example.cookiemaker.fragments
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.MainActivity
import com.example.cookiemaker.R
import com.example.cookiemaker.adapter.RecipeListAdapter
import pe.edu.ulima.pm.ulgamestore.model.Receta
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class CreateRecipeFragment: Fragment() {
    lateinit var ACTIVITY : MainActivity
    interface crearReceta{
        fun OnClickCrear(menuName: String)
    }

    private var listener: crearReceta? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as crearReceta
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ACTIVITY = context as MainActivity
        return inflater.inflate(R.layout.fragment_addcookie,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)
        btnGuardar.setOnClickListener{ _ : View ->
            listener?.OnClickCrear("recipes")


            val receta = Receta(1,"Test Save","USER")
            ACTIVITY.recetasManager.addReceta(receta)
        }

        val btnIngredientes = view.findViewById<Button>(R.id.btnIngredientes)
        btnIngredientes.setOnClickListener{ _ : View ->
            listener?.OnClickCrear("ingredientes")
        }
    }
}