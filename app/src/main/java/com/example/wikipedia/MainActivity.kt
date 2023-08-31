package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.wikipedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar( binding.toolBarMain )
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this ,
            binding.drawerLayoutMain ,
            binding.toolBarMain ,
            R.string.openDrawer ,
            R.string.closeDrawer
        )
        binding.drawerLayoutMain.addDrawerListener( actionBarDrawerToggle )
        actionBarDrawerToggle.syncState()
        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                }

                R.id.menu_photographer -> {

                }

                R.id.menu_video_maker -> {

                }

                R.id.menu_translator -> {

                }

                // ---------------------------------

                R.id.menu_open_wikipedia -> {

                }

                R.id.menu_open_wikimedia -> {

                }

            }

            true
        }
    }
}