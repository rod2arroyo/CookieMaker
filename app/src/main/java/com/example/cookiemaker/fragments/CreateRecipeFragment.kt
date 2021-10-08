package com.example.cookiemaker.fragments
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cookiemaker.R

class CreateRecipeFragment: Fragment() {
    interface OnMenuClicked2{
        fun OnClick(menuName: String)
    }

    private var listener: OnMenuClicked2? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as OnMenuClicked2
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_addcookie,container,false)
    }
}