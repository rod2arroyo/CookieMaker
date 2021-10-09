package com.example.cookiemaker.fragments
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookiemaker.*
import com.example.cookiemaker.adapter.RecipeListAdapter
import com.example.cookiemaker.adapter.ingredientsAdapter
import com.example.cookiemaker.adapter.recetaingredientesAdapter
import com.example.cookiemaker.listanueva
import pe.edu.ulima.pm.ulgamestore.model.Ingrediente
import pe.edu.ulima.pm.ulgamestore.model.Receta
import pe.edu.ulima.pm.ulgamestore.model.RecetasManager

class CreateRecipeFragment: Fragment() {
    lateinit var ACTIVITY : MainActivity
    interface crearReceta{
        fun OnClickCrear(menuName: String)
    }

    //variablesss
    var idactual : Int =1

    //---------
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

        val recycleringredients = view.findViewById<RecyclerView>(R.id.recyclerrecetaactual)
        //recycleringredients.adapter = ingredientsAdapter(ACTIVITY.recetasManager.getIngredientes())
        ///aquii nueva lista
        recycleringredients.adapter = recetaingredientesAdapter(listaactualreceta)


        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)
        btnGuardar.setOnClickListener{ _ : View ->


            val textnombre = view.findViewById<TextView>(R.id.nombrereceta)
            val receta = Receta(idactual,textnombre.text.toString(),ACTIVITY.username.toString(),listaactualreceta)
            idactual=idactual+1
            for (i in 0..(listanueva.size-1)){
                Log.i("listanuevaantes..->", listanueva[i].nombre)
            }
            listaactualreceta = arrayListOf()
            listanueva= arrayListOf()

            for (i in 0..(listanueva.size-1)){
               println("listadespues..->"+listanueva[i].nombre)
            }
            println("lustaantes del boton tamaño-->>>" + listanueva.size)


            //ACTIVITY.recetasManager.addReceta(receta)
            recetasManagerop.addReceta(receta)
            listener?.OnClickCrear("recipes")
        }

        val btnIngredientes = view.findViewById<Button>(R.id.btnIngredientes)
        btnIngredientes.setOnClickListener{ _ : View ->
            listener?.OnClickCrear("ingredientes")
        }
    }
}