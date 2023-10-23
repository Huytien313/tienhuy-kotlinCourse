package com.kotlin.example.mypet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kotlin.example.mypet.data.PetDatabase
import com.kotlin.example.mypet.databinding.ActivityMainBinding
import com.kotlin.example.mypet.repository.PetRepository
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_main)

    }
}