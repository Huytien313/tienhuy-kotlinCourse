package com.kotlin.example.mypet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.FragmentStartBinding

class FragmentStart: Fragment(){

    private var _binding : FragmentStartBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater,container, false)
        val root: View = binding.root
        binding.letsGo.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentStart_to_homeFragment)
        }
        return root
    }
}