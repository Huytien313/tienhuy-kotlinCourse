package com.kotlin.example.mypet.repository

import com.kotlin.example.mypet.data.PetDatabase
import com.kotlin.example.mypet.model.Pet

class PetRepository (
    val db: PetDatabase
    ){
    suspend fun upsert(pet: Pet) = db.petDao().insertPet(pet)
    fun getSavedPet() = db.petDao().getPets()
}