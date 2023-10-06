package com.kotlin.example.mypet.data


import androidx.lifecycle.LiveData
import androidx.room.*
import com.kotlin.example.mypet.model.Pet

@Dao
interface PetDao {
    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(pet: Pet): Long

    @Query("SELECT * FROM pets ")   // articles = tableName in data
    fun getAllArticles(): LiveData<List<Pet>>
}