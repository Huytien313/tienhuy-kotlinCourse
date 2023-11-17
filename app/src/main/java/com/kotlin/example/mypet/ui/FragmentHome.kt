package com.kotlin.example.mypet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.kotlin.example.mypet.Adapters.PetAdapters
import com.kotlin.example.mypet.PetViewModel
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.FragmentHomeBinding
import com.kotlin.example.mypet.model.Pet
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHome.newInstance] factory method to
 * create an instance of this fragment.
 */

class FragmentHome : Fragment() {
    private val petViewModel: PetViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val binding = FragmentHomeBinding.bind(view)

        val adapter = PetAdapters {
            // update pet tương ướng khi hiển thị trên PetDetail
            petViewModel.updateCurrentPet(it)
            // điều hướng tới detailPet
            findNavController()
                .navigate(R.id.action_fragmentHome_to_fragmentDetailPet,
                    bundleOf("detailPet" to it) )
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this.context, 2)
        adapter.submitList(petViewModel.petData)
        binding.groupToggle.check(R.id.button_pet)

        binding.groupToggle.addOnButtonCheckedListener { groupToggle, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.button_pet -> adapter.submitList(petViewModel.petData)
                    R.id.button_cat -> adapter.submitList(petViewModel.petData.filter { pet: Pet -> pet.category == 1 })
                    R.id.button_dog -> adapter.submitList(petViewModel.petData.filter { pet: Pet -> pet.category == 0 })
                }
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}