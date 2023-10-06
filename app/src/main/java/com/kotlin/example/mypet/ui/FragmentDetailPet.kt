package com.kotlin.example.mypet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.kotlin.example.mypet.PetViewModel
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.FragmentDetailPetBinding

class FragmentDetailPet : Fragment() {

    private val petViewModel : PetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_pet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailPetBinding.bind(view)
        petViewModel.currentPet.observe(this.viewLifecycleOwner){
            binding.petBreedDetail.text = getString(it.breed)
            binding.petOldDetail.text = getString(it.yearOld)
            binding.petTypicals.text = getString(it.typical)
            binding.petWeight.text = getString(it.typical)
            binding.petDetail.text = getString(it.description)
            binding.petImageDetail.load(it.petImage)
        }
    }
}