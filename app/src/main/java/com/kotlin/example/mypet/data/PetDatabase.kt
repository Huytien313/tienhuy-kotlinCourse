package com.kotlin.example.mypet.data

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kotlin.example.mypet.model.Pet
import com.kotlin.example.mypet.ui.FragmentHome

@Database(entities = [Pet::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PetDatabase: RoomDatabase() {
    abstract fun petDao(): PetDao

    companion object {
        @Volatile
        private var instance: PetDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance ?: createDatabase(context).also{
                instance = it}
        }
        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PetDatabase::class.java,
            "pet_db"
        ).build()
    }
}