package com.kotlin.example.mypet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.kotlin.example.mypet.PetViewModel
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.HomeFragmentBinding

class HomeFragment: Fragment() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    private val petViewModel: PetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.home_fragment, container, false)
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        val bottomNav = bottomNavigationView
        bottomNav.setOnNavigationItemSelectedListener(navListener)
        childFragmentManager.beginTransaction().replace(R.id.framelayout,FragmentHome()).commit()
        return view
    }
        private val navListener = BottomNavigationView.OnNavigationItemSelectedListener {

            lateinit var selectedFragment: Fragment

            when (it.itemId) {
                R.id.homeFragment -> {
                    selectedFragment = FragmentHome()
                }

                R.id.favoriteFragment -> {
                    selectedFragment = FragmentFavorite()
                }

                R.id.contactFragment -> {
                    selectedFragment = FragmentContact()
                }

                R.id.messageFragment -> {
                    selectedFragment = FragmentMessage()
                }
            }
            childFragmentManager.beginTransaction().replace(R.id.framelayout, selectedFragment)
                .commit()
            true
        }
}