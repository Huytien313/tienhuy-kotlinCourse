package com.kotlin.example.mypet.repository

import com.kotlin.example.mypet.data.PetDatabase
import com.kotlin.example.mypet.model.Pet

class PetRepository (
    val db: PetDatabase
    ){
    suspend fun upsert(pet: Pet) = db.getPetDao().upsert(pet)
    fun getSavedPet() = db.getPetDao().getAllArticles()
}