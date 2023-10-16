package com.digibankapp.feature.registrasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.digibankapp.R
import com.digibankapp.databinding.ActivityRegistrasiBinding

class Registrasi : AppCompatActivity() {
    private lateinit var viewmodel : RegisViewModel
    lateinit var binding: ActivityRegistrasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel = ViewModelProvider(this).get(RegisViewModel::class.java)

        binding.apply {
            etEmail.editText?.doOnTextChanged { text, start, before, count ->
                if (viewmodel.validateEmail(text.toString())){
                    binding.etEmail.isErrorEnabled = false
                    binding.btnRegist.isEnabled = true
                } else {
                    binding.etEmail.isErrorEnabled = true
                    binding.btnRegist.isEnabled = false
                    binding.etEmail.error = "Email yang dimasukkan harus sesuai format"
                }
            }
            etPassword.editText?.doOnTextChanged { text, start, before, count ->
                if (viewmodel.validatePassword(text.toString())){
                    binding.etPassword.isErrorEnabled = false
                    binding.btnRegist.isEnabled = true
                } else {
                    binding.etPassword.isErrorEnabled = true
                    binding.btnRegist.isEnabled = false
                    binding.etPassword.error = "Password harus terdiri dari huruf dan angka"
                }
            }
            etTelepon.editText?.doOnTextChanged { text, start, before, count ->
                if (viewmodel.validateNohp(text.toString())){
                    binding.etTelepon.isErrorEnabled = true
                    binding.btnRegist.isEnabled = false
                    binding.etTelepon.error = "Bilangan harus min. 10 karakter"
                } else {
                    binding.etTelepon.isErrorEnabled = false
                    binding.btnRegist.isEnabled = true
                }
            }
            etNIK.editText?.doOnTextChanged { text, start, before, count ->
                if (viewmodel.validateNik(text.toString())){
                    binding.etNIK.isErrorEnabled = true
                    binding.btnRegist.isEnabled = false
                    binding.etNIK.error = "Bilangan harus min. 16 karakter"
                } else {
                    binding.etNIK.isErrorEnabled = false
                    binding.btnRegist.isEnabled = true
                }
            }
        }

    }
}