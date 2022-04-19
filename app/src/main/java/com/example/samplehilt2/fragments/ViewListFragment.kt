package com.example.samplehilt2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplehilt2.ListAdapter
import com.example.samplehilt2.R
import com.example.samplehilt2.SampleViewModel
import com.example.samplehilt2.databinding.FragmentViewListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewListFragment : Fragment() {
    lateinit var binding: FragmentViewListBinding
    private lateinit var listAdapter: ListAdapter
    private val viewModel: SampleViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewListBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }


    private fun init() {
        viewModel.getAllData().observe(viewLifecycleOwner) {
            listAdapter.setData(it)
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.addFragment)


        }


        binding.data.apply {
            listAdapter = ListAdapter()
            val llm = LinearLayoutManager(requireContext())
            llm.orientation = LinearLayoutManager.VERTICAL
            adapter = listAdapter


        }
    }
}