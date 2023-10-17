package com.kotlin.example.mypet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.example.mypet.model.Pet
import com.kotlin.example.mypet.data.PetData
import com.kotlin.example.mypet.repository.PetRepository
import kotlinx.coroutines.launch

class PetViewModel: ViewModel() {
    val petRepository: PetRepository ?=null

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
    fun savePet(pet: LiveData<Pet>) = viewModelScope.launch {
        petRepository?.insert(pet)
    }
    fun getSavedPet() = petRepository?.getSavedPet()

    fun deletePet(pet: Pet) = viewModelScope.launch {
        petRepository?.deletePet(pet)
    }
}
//class PetViewModelProviderFactory(
//    val petRepository: PetRepository
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return PetViewModel(petRepository) as T
//    }
//}