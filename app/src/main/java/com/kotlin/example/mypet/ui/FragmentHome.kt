package com.kotlin.example.mypet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.transaction
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.kotlin.example.mypet.Adapters.PetAdapters
import com.kotlin.example.mypet.Adapters.TabPetAdapters
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHome : Fragment() {
    private lateinit var petAdapter: PetAdapters

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        tabLayout = view.findViewById(R.id.tablayout)
        viewPager = view.findViewById(R.id.viewPager)

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

        return view
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
//        tabPetAdapter.setOnItemClickListener{
//            childFragmentManager.beginTransaction().replace(R.id.homeFragment, FragmentDetailPet())
//                .commit()
//            findNavController().navigate(
//                R.id.action_tabAll_to_fragmentDetailPet
//            )
//        }
    }
}