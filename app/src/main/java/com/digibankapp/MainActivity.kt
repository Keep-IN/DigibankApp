package com.digibankapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.digibankapp.databinding.ActivityMainBinding
import com.digibankapp.features.verification.VerificationActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textSample.setOnClickListener {
            startActivity(Intent(this, VerificationActivity::class.java))
        }
    }
}