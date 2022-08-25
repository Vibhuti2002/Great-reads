package com.appoitment.greatreads.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.appoitment.greatreads.R
import com.appoitment.greatreads.databinding.ActivityLoginBinding
import com.appoitment.greatreads.databinding.FragmentLoginBinding


class Login : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.bAdmin).setOnClickListener {
            findNavController().navigate(R.id.action_login4_to_login_Admin4)
        }
        view.findViewById<Button>(R.id.bStudent).setOnClickListener {
           findNavController().navigate(R.id.action_login4_to_login_Student2)
        }

    }
}