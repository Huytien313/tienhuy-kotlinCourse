package com.kotlin.example.mypet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kotlin.example.mypet.Adapters.PetAdapters

import com.kotlin.example.mypet.PetViewModel
import com.kotlin.example.mypet.databinding.FragmentHomeBinding

class HomeFragment: Fragment(){
    private var _binding : FragmentHomeBinding ?= null
    private val binding get() = _binding!!

    private val petViewModel: PetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)

        val adapter = PetAdapters{
            petViewModel.updateCurrentPet(it)

        }
        binding.recyclerView.layoutManager = GridLayoutManager(this.context,2)
        adapter.submitList(petViewModel.petData)
    }
}