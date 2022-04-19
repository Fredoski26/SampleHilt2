package com.example.samplehilt2.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.samplehilt2.R
import com.example.samplehilt2.SampleViewModel
import com.example.samplehilt2.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val viewModel: SampleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAddBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }


    private fun init() {
        binding.addBtn.setOnClickListener {
            insertData()
        }
    }


    private fun insertData() {
        val firstName = binding.editFirstName.text.toString()
        val lastName = binding.editLastName.text.toString()
        val email = binding.emailAddress.text.toString()



        if (checkEditText(firstName, lastName, email)) {
            viewModel.insertRecords(firstName, lastName, email).observe(viewLifecycleOwner) {
                Toast.makeText(context, "User added successful", Toast.LENGTH_LONG).show()
            }
            Toast.makeText(requireContext(), "User added successful", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.viewListFragment)
        } else {
            Toast.makeText(requireContext(), "Fill in all field", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkEditText(first_N: String, last_N: String, email_N: String): Boolean {
        return !(TextUtils.isEmpty(first_N) && TextUtils.isEmpty(last_N) && TextUtils.isEmpty(
            email_N
        ))
    }

}