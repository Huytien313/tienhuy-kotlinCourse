package com.kotlin.example.mypet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.example.mypet.model.Pet
import com.kotlin.example.mypet.data.PetData

class PetViewModel : ViewModel() {
    private var _currentPet : MutableLiveData<Pet> = MutableLiveData<Pet>()
    val currentPet : LiveData<Pet> get() = _currentPet

    private var _petData : ArrayList<Pet> = ArrayList()
    val petData : ArrayList<Pet> get() = _petData

    init {
        _petData = PetData.getPetData()
        _currentPet.value = _petData[0]
    }
    fun updateCurrentPet(pet: Pet){
        _currentPet.value = pet
    }
}