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
                } else {
                    binding.etEmail.isErrorEnabled = true
                    binding.etEmail.error = "Email yang dimasukkan harus sesuai format"
                }
                validateInput()
            }
            etPassword.editText?.doOnTextChanged { text, start, before, count ->
                if (viewmodel.validatePassword(text.toString())){
                    binding.etPassword.isErrorEnabled = false
                } else {
                    binding.etPassword.isErrorEnabled = true
                    binding.etPassword.error = "Password harus terdiri dari huruf dan angka"
                }
                validateInput()
            }
            etTelepon.editText?.doOnTextChanged { text, start, before, count ->
                if (viewmodel.validateNohp(text.toString())) {
                    binding.etTelepon.isErrorEnabled = false
                } else {
                    binding.etTelepon.isErrorEnabled = true
                    binding.etTelepon.error = "No Telepon kurang dari 10 karakter"

                }
                validateInput()
            }
            etNIK.editText?.doOnTextChanged { text, start, before, count ->
                if (viewmodel.validateNik(text.toString())) {
                    binding.etNIK.isErrorEnabled = false
                } else {
                    binding.etNIK.isErrorEnabled = true
                    binding.etNIK.error = "NIK kurang dari 16 karakter"
                }
                validateInput()
            }
        }
    }
    private fun validateInput(){
        binding.btnRegist.isEnabled = viewmodel.validateEmail(binding.etEmail.editText?.text.toString())
                && viewmodel.validatePassword(binding.etPassword.editText?.text.toString())
                && viewmodel.validateNik(binding.etNIK.editText?.text.toString())
                && viewmodel.validateNohp(binding.etTelepon.editText?.text.toString())
    }
}