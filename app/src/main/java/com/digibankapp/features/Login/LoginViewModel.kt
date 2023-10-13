package com.digibankapp.features.Login

import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    var isEmailValid = false
    fun validateEmail(email: String): Boolean{
        isEmailValid = email.length < 8
        return isEmailValid
    }
}