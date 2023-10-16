package com.digibankapp.feature.registrasi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import javax.xml.validation.Validator

class RegisViewModel: ViewModel() {
    var isEmailValid = false
    var isPasswordValid = false
    var isNikValid = false
    var isNohpValid = false
    fun validateEmail(email: String): Boolean{
        isEmailValid = email.contains("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex())
        return isEmailValid
    }

    fun validatePassword(password: String): Boolean{
        isPasswordValid = password.contains ("^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{8,}\$".toRegex())
        return  isPasswordValid
    }

    fun validateNohp(noHp : String) : Boolean{
        isNohpValid = noHp.length < 10
        return isNohpValid
    }

    fun validateNik(nik : String) : Boolean{
        isNikValid = nik.length < 16
        return isNikValid
    }
}