package com.kotlin.example.mypet.data

import android.content.Context
//import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kotlin.example.mypet.model.Pet


@Database(entities = [Pet::class], version = 1, exportSchema = false)

abstract class PetDatabase: RoomDatabase() {
    abstract fun getPetDao(): PetDao

    companion object {
        @Volatile
        private var instance: PetDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) : PetDatabase  =
            instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{
                instance = it
            }
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
            context.applicationContext,
            PetDatabase::class.java,
            "pet_db"
        ).build()
    }
}