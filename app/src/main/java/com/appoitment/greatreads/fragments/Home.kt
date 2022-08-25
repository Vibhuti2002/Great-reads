package com.appoitment.greatreads.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.appoitment.greatreads.R
import com.appoitment.greatreads.databinding.FragmentHomeBinding
import com.appoitment.greatreads.dataclasses.HomeDataClass


class Home : Fragment() {

    private lateinit var binding : FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        val data : MutableList<HomeDataClass> = ArrayList()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    fun onItemClick(position: Int) {
        val pos = position
        if (position == 0){
            val action = .actionHomeFragmentToWarmUpFragment()
            findNavController().navigate(action)
        }else {
            val action = HomeFragmentDirections.actionHomeFragmentToCategoriesFragment(pos)
            findNavController().navigate(action)
        }
    }
}