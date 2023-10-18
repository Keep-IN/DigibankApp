package com.digibankapp.feature.buatRekening

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digibankapp.R
import com.digibankapp.databinding.ActivityBuatMpinBinding
import com.digibankapp.databinding.ActivityBuatRekeningBinding
import com.digibankapp.feature.buatMpin.BuatMpin

class BuatRekening : AppCompatActivity() {
    private lateinit var binding: ActivityBuatRekeningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBuatRekeningBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        validateInput()

        binding.btnPilihKartu.setOnClickListener {
            startActivity(Intent(this, BuatMpin::class.java))
        }

        binding.cvSilver.setOnClickListener {
            binding.apply {
                cvSilver.setStrokeColor(Color.parseColor("#6C63FF"))
                cvGold.setStrokeColor(Color.parseColor("#FFFFFF"))
                cvPlat.setStrokeColor(Color.parseColor("#FFFFFF"))
            }
        }

        binding.cvGold.setOnClickListener {
            binding.apply {
                cvSilver.setStrokeColor(Color.parseColor("#FFFFFF"))
                cvGold.setStrokeColor(Color.parseColor("#6C63FF"))
                cvPlat.setStrokeColor(Color.parseColor("#FFFFFF"))
            }

            binding.cvPlat.setOnClickListener {
                binding.apply {
                    cvSilver.setStrokeColor(Color.parseColor("#FFFFFF"))
                    cvGold.setStrokeColor(Color.parseColor("#FFFFFF"))
                    cvPlat.setStrokeColor(Color.parseColor("#6C63FF"))
                }
            }
        }
    }
    private fun validateInput() {
        binding.btnPilihKartu.isEnabled =
        binding.cvSilver.hasOnClickListeners() ||
        binding.cvGold.hasOnClickListeners() ||
        binding.cvPlat.hasOnClickListeners()
    }
}