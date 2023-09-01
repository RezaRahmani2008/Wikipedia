package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragment.FragmentExplorer
import com.example.wikipedia.fragment.FragmentProfile
import com.example.wikipedia.fragment.FragmentTrend

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
        firstRun()
        binding.bottomNavigationMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_expelorer ->{
                    replaceFragment(FragmentExplorer())
                }
                R.id.menu_trend ->{
                    replaceFragment(FragmentTrend())
                }
                R.id.menu_profile ->{
                    replaceFragment(FragmentProfile())
                }

            }
            true
        }
        binding.bottomNavigationMain.setOnItemReselectedListener {  }
    }

    fun replaceFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container ,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun firstRun(){
        replaceFragment(FragmentExplorer())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_expelorer
    }
}