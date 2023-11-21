package com.kotlin.example.mypet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.example.mypet.repository.PetRepository

class PetsViewModelProviderFactory (
    val petRepository : PetRepository
    ): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PetViewModel(petRepository) as T
    }
}