package com.kotlin.example.mypet.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.kotlin.example.mypet.PetViewModel
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.FragmentDetailPetBinding
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class FragmentDetailPet : Fragment() {
    val TAG = "FramentDetailPet"

//    Dùng sai: lateinit var petViewModel : PetViewModel
    private val petViewModel : PetViewModel by activityViewModels()
//    private var petDatabase : PetDatabase?= null
    // để sử dụng Fragment..Args cần plugin 'androidx.navigation.safeargs.kotlin'
    private val args : FragmentDetailPetArgs by navArgs()

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

        val pet = args.detailPet
        binding.fb.setOnClickListener{
            Log.i(TAG,"fvb on click")
            println(pet)
            petViewModel.savePet(pet)
        }
    }
}