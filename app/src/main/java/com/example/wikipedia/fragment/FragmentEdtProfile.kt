package com.example.wikipedia.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.wikipedia.R
import com.example.wikipedia.databinding.FragmentEditProfileBinding
import java.util.Calendar

const val KEY_SET_DATA_USERNAME = "1"
const val KEY_SET_DATA_EMAIL = "2"
const val KEY_SET_DATA_GENDER = "3"
const val KEY_SET_DATA_AGE = "4"

class FragmentEdtProfile : Fragment() {
    lateinit var binding: FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(layoutInflater, container, false)


        adapterTextFildItems()
        binding.textFildProfileDateOfBirth.setEndIconOnClickListener {
            showDatePickerDialog()
        }

        binding.btnProfileCancel.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_main_container, FragmentProfile())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnProfileACCEPT.setOnClickListener {
            val username = binding.edtProfileUsername.text.toString()
            val email = binding.edtProfileEmail.text.toString()
            val gender = binding.edtProfileGender.text.toString()
            val age = binding.edtProfileDateOfBirth.text.toString()
            if (username.isNotEmpty() && email.isNotEmpty() && gender.isNotEmpty() && age.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putString("1", username)
                bundle.putString("2", email)
                bundle.putString("3", gender)
                bundle.putString("4", age)

                val fragment = FragmentProfile()
                fragment.arguments = bundle

                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_main_container, fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            } else {
            }

        }

        return binding.root
    }


    private fun adapterTextFildItems() {
        val items = listOf("Man", "Female", "other")
        val adapter = ArrayAdapter(requireContext(), R.layout.item_textinputlayout, items)
        binding.edtProfileGender.setAdapter(adapter)
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { view, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedYear/${selectedMonth + 1}/$selectedDay"
                binding.textFildProfileDateOfBirth.editText?.setText(selectedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis
        datePickerDialog.show()
    }

}