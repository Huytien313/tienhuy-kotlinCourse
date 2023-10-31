package com.kotlin.example.mypet.repository

import com.kotlin.example.mypet.data.PetDatabase
import com.kotlin.example.mypet.model.Pet
import javax.inject.Inject

class PetRepository (
    val db: PetDatabase
    ){
    suspend fun insert(pet: Pet) = db.getPetDao().insertPet(pet)
    fun getSavedPet() = db.getPetDao().getPets()
    suspend fun deletePet(pet: Pet) = db.getPetDao().deletePet(pet)
}