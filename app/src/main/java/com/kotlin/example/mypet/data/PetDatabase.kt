package com.kotlin.example.mypet.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class PetDatabase: RoomDatabase() {
    abstract fun getPetDao(): PetDao

    companion object {
        @Volatile
        private var instance: PetDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance = it}
        }
        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PetDatabase::class.java,
            "pet_db"
        ).build()
    }
}