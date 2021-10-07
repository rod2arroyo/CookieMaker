package com.example.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cookiemaker.fragments.RecipesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment : Fragment = RecipesFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent,fragment)
        ft.commit()
    }
}