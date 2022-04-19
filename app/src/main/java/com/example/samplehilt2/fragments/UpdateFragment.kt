package com.example.samplehilt2.fragments

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.samplehilt2.R
import com.example.samplehilt2.SampleViewModel
import com.example.samplehilt2.databinding.FragmentUpdateBinding
import com.example.samplehilt2.model.SampleUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val viewModel: SampleViewModel by viewModels()
    var uId = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }


    private fun init() {
        val name = requireArguments().getString("first")
        val last = requireArguments().getString("last")
        val email = requireArguments().getString("email")
        uId = requireArguments().getString("uId")?.toInt() ?: -1
        binding.editFirstName.setText(name)
        binding.editLastName.setText(last)
        binding.emailAddress.setText(email)

        binding.button.setOnClickListener {
            updateData()
        }
    }


    private fun updateData() {
        val firstName = binding.editFirstName.text.toString()
        val lastName = binding.editLastName.text.toString()
        val email = binding.emailAddress.text.toString()


        if (checkEditText(firstName, lastName, email)) {
            Log.d("TAG", "onBindViewHolder: $uId")
            viewModel.updateDatas(uId, firstName, lastName, email)
                .observe(viewLifecycleOwner) {
                    if (it) {
                        Toast.makeText(requireContext(), "Update successful", Toast.LENGTH_LONG)
                            .show()
                        findNavController().navigate(R.id.viewListFragment)
                    } else {
                        Toast.makeText(requireContext(), "Update failed", Toast.LENGTH_LONG).show()
                    }
                }
            /*val updateUser = SampleUser(id, first_name = first_name, last_name = last_name, email = emial )
             viewModel.updateDatas(updateUser)*/

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