package com.appoitment.greatreads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.appoitment.greatreads.databinding.ActivityMainBinding
import com.appoitment.greatreads.fragments.Bookmark
import com.appoitment.greatreads.fragments.Home
import com.appoitment.greatreads.fragments.Profile

private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.bookmark -> replaceFragment(Bookmark())
                R.id.profile -> replaceFragment(Profile())

                else -> {

                }


            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flFragment, fragment)
        fragmentTransaction.commit()
    }
}