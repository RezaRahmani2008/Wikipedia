package com.example.wikipedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.R
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
        setSupportActionBar( binding.toolbarMain )
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this ,
            binding.drawerLayoutMain ,
            binding.toolbarMain ,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.drawerLayoutMain.addDrawerListener( actionBarDrawerToggle )
        actionBarDrawerToggle.syncState()
        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                }

                R.id.menu_photograph -> {

                }

                R.id.menu_vieo_maker -> {

                }

                R.id.menu_translator -> {

                }

                // ---------------------------------

                R.id.menu_open_wikipedia -> {

                }

                R.id.menu_open_wikipedia -> {

                }

            }

            true
        }
        firstRun()
        binding.bottomNavigationMain.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_explore ->{
                    replaceFragment(FragmentExplorer())
                }
                R.id.menu_trend ->{
                    replaceFragment(FragmentTrend())
                }
                R.id.menu_profile ->{
                    replaceFragment(FragmentProfile())
                }

            }
//            binding.navigationViewMain.menu.getItem(1).isChecked = false
            true
        }
        binding.bottomNavigationMain.setOnItemReselectedListener {  }
    }

    private fun replaceFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun firstRun(){
        replaceFragment(FragmentExplorer())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }
}