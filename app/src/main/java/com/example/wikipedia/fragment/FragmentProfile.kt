package com.example.wikipedia.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.wikipedia.R
import com.example.wikipedia.databinding.FragmentProfileBinding


class FragmentProfile : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private val PICK_IMAGE_REQUEST = 1
    private lateinit var selectedImageUri: Uri
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        setView()
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openEditProfile()

        binding.imgProfileOpengallery.setOnClickListener {
            openGallery()
        }
        binding.imgProfileMain.setOnClickListener {
            openGallery()
        }
    }
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
        }
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            data?.data?.let { imageUri ->
                selectedImageUri = imageUri
            }
        }
        val imageUri = Uri.parse(selectedImageUri.toString())
        Glide.with(this)
            .load(imageUri)
            .into(binding.imgProfileMain)
    }
    private fun openEditProfile(){

        binding.txtProfileUsername.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_main_container,  FragmentEdtProfile())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.txtProfileEmail.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_main_container,  FragmentEdtProfile())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.txtProfileGender.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_main_container,  FragmentEdtProfile())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.txtProfileDateOfBirth.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_main_container,  FragmentEdtProfile())
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
    private fun setView(){
        val bundle = arguments
        if (bundle != null) {
            val username = bundle.getString(KEY_SEND_DATA_USERNAME)
            val email = bundle.getString(KEY_SEND_DATA_EMAIL)
            val gender = bundle.getString(KEY_SEND_DATA_GENDER)
            val age = bundle.getString(KEY_SEND_DATA_AGE)
            binding.txtProfileUsername.text = username
            binding.txtProfileEmail.text = email
            binding.txtProfileGender.text = gender
            binding.txtProfileDateOfBirth.text = age
        }else{

        }

    }

}