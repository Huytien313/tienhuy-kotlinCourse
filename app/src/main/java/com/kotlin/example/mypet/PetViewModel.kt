package com.kotlin.example.mypet

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.kotlin.example.mypet.model.Pet
import com.kotlin.example.mypet.data.PetData
import com.kotlin.example.mypet.data.PetDatabase
import com.kotlin.example.mypet.repository.PetRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PetViewModel (
    val petRepository : PetRepository
): ViewModel() {
    private var _pet : MutableLiveData<Pet> = MutableLiveData<Pet>()
    val pet : LiveData<Pet> get() = _pet

    private var _currentPet : MutableLiveData<Pet> = MutableLiveData<Pet>()
    val currentPet : LiveData<Pet> get() = _currentPet

    private var _petData : ArrayList<Pet> = ArrayList()
    val petData : ArrayList<Pet> get() = _petData

    init {
        _petData = PetData.getPetData()
        // không có dòng này ko load đc thông tin lên detailPet
        _currentPet.value = _petData[0]
    }
    fun savePet(pet: Pet) = viewModelScope.launch {
        petRepository.insert(pet)
    }
    fun getSavedPet() = petRepository.getSavedPet()

    fun deletePet(pet: Pet) = viewModelScope.launch {
        petRepository.deletePet(pet)
    }
    // không có hàm này thì detailPet không update pet tương ứng mà
    // chỉ hiển thị pet[0]. kết hợp khai báo trong adapter của FragmentHome
    fun updateCurrentPet(pet: Pet) {
        _currentPet.value = pet
    }
}