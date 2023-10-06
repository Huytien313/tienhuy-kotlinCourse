package com.kotlin.example.mypet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.example.mypet.R

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentFavorite.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentFavorite : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
//        val fragmentManager = childFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.framelayout,FragmentFavorite())
//        fragmentTransaction.commit()

        return inflater.inflate(R.layout.fragment_favorit, container, false)

    }
}