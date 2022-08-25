package com.appoitment.greatreads

import android.os.Build.ID
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.appoitment.greatreads.databinding.ActivityLoginBinding
import com.appoitment.greatreads.fragments.Login_Admin
import com.appoitment.greatreads.fragments.Login_Student

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


}