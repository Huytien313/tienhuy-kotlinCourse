package com.kotlin.example.mypet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kotlin.example.mypet.data.PetDatabase
import com.kotlin.example.mypet.databinding.ActivityMainBinding
import com.kotlin.example.mypet.repository.PetRepository
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {

    lateinit var petViewModel : PetViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        val petRepository = PetRepository(PetDatabase(this))
        val viewModelProviderFactory = PetsViewModelProviderFactory(petRepository)
        petViewModel = ViewModelProvider(this, viewModelProviderFactory).get(PetViewModel::class.java)
    }
}