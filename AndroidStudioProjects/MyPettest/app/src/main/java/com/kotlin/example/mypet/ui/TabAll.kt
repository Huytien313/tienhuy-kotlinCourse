package com.kotlin.example.mypet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kotlin.example.mypet.Adapters.PetAdapters
import com.kotlin.example.mypet.PetViewModel
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.FragmentTabAllBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TabAll.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabAll : Fragment() {

    private val petViewModel: PetViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_all, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTabAllBinding.bind(view)
//        val binding = FragmentHomeBinding.bind(view)
        val adapter = PetAdapters{
//            petViewModel.updateCurrentPet(it)
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this.context,2)
        adapter.submitList(petViewModel.petData)
    }

}