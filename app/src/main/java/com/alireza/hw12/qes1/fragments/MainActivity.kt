package com.alireza.hw12.qes1.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.alireza.hw12.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var navigition: NavController
    lateinit var buttomNav: BottomNavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navigition = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navigition.graph)


        buttomNav = findViewById(R.id.bottomNavigationView)
        NavigationUI.setupWithNavController(buttomNav, navigition)


        buttomNav.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.miHome -> {
                    navigition.popBackStack()
                    navigition.navigate(R.id.homeFragment)
                }
                R.id.miComing -> {

                    navigition.navigate(R.id.coomingsoonFragment)
                }

                R.id.miFavorite -> {
                    navigition.popBackStack()
                    navigition.navigate (R.id.favFragment)
                }
                R.id.miProfile -> {
                    navigition.popBackStack()
                    navigition.navigate(R.id.profileFragment)
                }
            }
            true
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}





