package com.kotlin.example.mypet.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.kotlin.example.mypet.ui.TabAll
import com.kotlin.example.mypet.ui.TabCat
import com.kotlin.example.mypet.ui.TabDog
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabPetAdapters(fragment: Fragment, private val tabCount: Int) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> TabAll()
            1 -> TabCat()
            2 -> TabDog()
            else -> TabAll()
        }
    }
}