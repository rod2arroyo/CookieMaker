package com.example.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cookiemaker.fragments.CreateRecipeFragment
import com.example.cookiemaker.fragments.IngredientFragment
import com.example.cookiemaker.fragments.RecipesFragment

class MainActivity : AppCompatActivity() , RecipesFragment.OnMenuClicked, CreateRecipeFragment.crearReceta{
    private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(RecipesFragment())
        fragments.add(CreateRecipeFragment())
        fragments.add(IngredientFragment())

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent,fragments[0])
        ft.commit()
    }

    fun changeRecipesFragment(){
        val fragment = fragments[0]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent,fragment)
        ft.commit()
    }

    fun changeCreateRecipe(){
        val fragment = fragments[1]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent,fragment)
        ft.commit()
    }

    fun changeIngredientesFragment(){
        val fragment = fragments[2]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent,fragment)
        ft.commit()
    }

    override fun OnClick(menuName: String) {
        if(menuName == "createRecipe"){
            changeCreateRecipe()
        }
    }

    override fun OnClickCrear(menuName: String){
        if(menuName == "recipes"){
            changeRecipesFragment()
        }else if(menuName == "ingredientes"){
            changeIngredientesFragment()
        }
    }


}