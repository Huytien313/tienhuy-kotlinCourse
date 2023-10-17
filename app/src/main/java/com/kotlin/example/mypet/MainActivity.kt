package com.kotlin.example.mypet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kotlin.example.mypet.data.PetDatabase
import com.kotlin.example.mypet.repository.PetRepository

class MainActivity : AppCompatActivity() {

    lateinit var  petViewModel: PetViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val petRepository = PetRepository(PetDatabase(this))
//        val viewModelProviderFactory = PetViewModelProviderFactory(petRepository)
//        petViewModel = ViewModelProvider(this, viewModelProviderFactory).get(PetViewModel::class.java)
    }
}