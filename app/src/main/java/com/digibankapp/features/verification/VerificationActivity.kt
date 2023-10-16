package com.digibankapp.features.verification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.digibankapp.R
import com.digibankapp.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerificationBinding
    private lateinit var verificationViewModel: VerificationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        verificationViewModel = ViewModelProvider(this).get(VerificationViewModel::class.java)

        binding.tilNIK.editText?.doOnTextChanged{ text, start, before, count ->
            if(verificationViewModel.validateNIK(text.toString())){
                binding.tilNIK.isErrorEnabled = false
            } else {
                binding.tilNIK.isErrorEnabled = true
                binding.tilNIK.error = "NIK minimal 16 karakter"

            }
            validateInput()
        }

        binding.tilNorek.editText?.doOnTextChanged{ text, start, before, count ->
            if(verificationViewModel.validateNorek(text.toString())){
                binding.tilNorek.isErrorEnabled = false
            } else {
                binding.tilNorek.isErrorEnabled = true
                binding.tilNorek.error = "Nomor rekening minimal 8 karakter"
            }
            validateInput()
        }
    }
    private fun validateInput(){
        binding.btnLanjut.isEnabled = verificationViewModel.validateNIK(binding.tilNIK.editText?.text.toString())
                && verificationViewModel.validateNorek(binding.tilNorek.editText?.text.toString())
    }
}