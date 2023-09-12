package com.example.wikipedia.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.wikipedia.FragmentPhotographer
import com.example.wikipedia.R
import com.example.wikipedia.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

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
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.drawerLayoutMain.addDrawerListener( actionBarDrawerToggle )
        actionBarDrawerToggle.syncState()
        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    val dialog = SweetAlertDialog(this, SweetAlertDialog.NORMAL_TYPE)
                        dialog.titleText = "Alert"
                    dialog.confirmText = "Confirm"
                    dialog.cancelText = "Cancel"
                    dialog.contentText = "Wanna be a Writer?"
                    dialog.setCancelClickListener {
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                        Toast.makeText(this, "you can be a writer just work :)", Toast.LENGTH_SHORT)
                            .show()
                    }
                    dialog.show()

                }

                R.id.menu_photographer -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frame_main_container, FragmentPhotographer())
                    transaction.addToBackStack(null)
                    transaction.commit()

                    binding.navigationViewMain.setCheckedItem(R.id.menu_photographer)

                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)



                }

                R.id.menu_video_maker -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    Snackbar
                        .make(binding.root, "You can Create Video!", Snackbar.LENGTH_LONG)
                        .setAction("ddd"){

                        }
                        .setActionTextColor(ContextCompat.getColor(this, R.color.white))
                        .setBackgroundTint(ContextCompat.getColor(this, R.color.blue))
                        .show()
                }

                R.id.menu_translator -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
                }

                // ---------------------------------

                R.id.menu_open_wikipedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    openWebsite("https://www.wikipedia.org/")
                }

                R.id.menu_open_wikimedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    openWebsite("https://www.wikimedia.org/")
                }

            }

            true
        }

    }

    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.navigationViewMain.menu.getItem(1).isChecked = false
    }
}