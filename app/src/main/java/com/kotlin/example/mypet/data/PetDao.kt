package com.kotlin.example.mypet.data


import androidx.lifecycle.LiveData
import androidx.room.*
import com.kotlin.example.mypet.model.Pet

@Dao
interface PetDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPet(pet: Pet)

    @Query("SELECT * FROM pets ")   // pets = tableName in data
    fun getPets() : LiveData<List<Pet>>

    @Delete
    suspend fun deletePet(pet: Pet)
}