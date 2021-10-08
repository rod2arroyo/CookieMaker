package com.example.cookiemaker.fragments
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cookiemaker.R

class CreateRecipeFragment: Fragment() {
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
        return inflater.inflate(R.layout.fragment_addcookie,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnGuardar = view.findViewById<Button>(R.id.btnGuardar)
        btnGuardar.setOnClickListener{ _ : View ->
            listener?.OnClickCrear("recipes")
        }

        val btnIngredientes = view.findViewById<Button>(R.id.btnIngredientes)
        btnIngredientes.setOnClickListener{ _ : View ->
            listener?.OnClickCrear("ingredientes")
        }
    }
}