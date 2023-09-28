package com.kotlin.example.mypet.ui

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kotlin.example.mypet.Adapters.PetAdapters
import com.kotlin.example.mypet.Adapters.TabPetAdapters

import com.kotlin.example.mypet.PetViewModel
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.FragmentHomeBinding
import com.kotlin.example.mypet.databinding.FragmentTabAllBinding

class HomeFragment: Fragment() {
    // 1.
    private lateinit var tabLayout: TabLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    //    private lateinit var recyclerView: RecyclerView
    private lateinit var viewPager: ViewPager2
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val petViewModel: PetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        tabLayout = view.findViewById(R.id.tablayout)
        viewPager = view.findViewById(R.id.viewPager)
        bottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        val tabadapter = TabPetAdapters(this, tabLayout.tabCount)
        viewPager.adapter = tabadapter

        viewPager.unregisterOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        // chua xong
        bottomNavigationView.setSelectedItemId(R.id.homeFragment)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.fragmentMessage -> replaceFragment(FragmentMessage())
                R.id.fragmentFavorite -> replaceFragment(FragmentFavorite())
                R.id.fragmentContact -> replaceFragment(FragmentContact())
            }
            true
        }
        return view
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.viewPager, fragment)
        fragmentTransaction.commit()
    }
}