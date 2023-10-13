package com.digibankapp.features.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.digibankapp.R
import com.digibankapp.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private  lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.tilEmail.editText?.doOnTextChanged { text, start, before, count ->
            if (loginViewModel.validateEmail(text.toString())){
                binding.tilEmail.isErrorEnabled = true
                binding.tilEmail.error = "Email yang dimasukkan salah"
            } else {
                binding.tilEmail.isErrorEnabled = false
            }
        }
    }
}