package com.kotlin.example.mypet.data


import androidx.lifecycle.LiveData
import androidx.room.*
import com.kotlin.example.mypet.model.Pet

@Dao
interface PetDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPet(pet: Pet)

//    @Query("SELECT * FROM pets ")   // articles = tableName in data
    fun getPets(): List<Pet>
}