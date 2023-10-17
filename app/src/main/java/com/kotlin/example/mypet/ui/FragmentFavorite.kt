package com.kotlin.example.mypet.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.example.mypet.Adapters.PetAdapters
import com.kotlin.example.mypet.PetViewModel
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.FragmentFavoriteBinding
import com.kotlin.example.mypet.model.Pet

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentFavorite.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentFavorite : Fragment() {
    private val TAG ="FragmentFavorite"
    private val petViewModel : PetViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteBinding.bind(view)

        val adapter = PetAdapters{}
        binding.favoritePets.adapter = adapter
        binding.favoritePets.layoutManager = LinearLayoutManager(activity)
//        adapter.submitList(petViewModel.petData.filter { pet: Pet -> pet.category == 1 })
        petViewModel.getSavedPet()?.observe(
            viewLifecycleOwner, Observer { pets ->
                adapter.differ.submitList(pets)
            })
    }
}