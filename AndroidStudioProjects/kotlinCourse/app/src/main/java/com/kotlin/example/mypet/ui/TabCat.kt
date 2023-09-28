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
import com.kotlin.example.mypet.databinding.FragmentTapCatBinding
import com.kotlin.example.mypet.model.Pet

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TabCat.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabCat : Fragment() {
    private val petViewModel: PetViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tap_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTapCatBinding.bind(view)
        val adapter = PetAdapters{}
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this.context,2)
        adapter.submitList(petViewModel.petData.filter { pet: Pet -> pet.category == 1})
    }
}