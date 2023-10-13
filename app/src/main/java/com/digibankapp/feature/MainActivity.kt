package com.digibankapp.feature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digibankapp.R
import com.digibankapp.databinding.ActivityMainBinding
import com.digibankapp.feature.registrasi.Registrasi

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtAwal.setOnClickListener {
            startActivity(Intent(this, Registrasi::class.java))
        }
    }
}