package com.digibankapp.features

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digibankapp.R
import com.digibankapp.databinding.ActivityMainBinding
import com.digibankapp.features.Login.Login

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tvTest.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }
}