package com.digibankapp.features.verification

import androidx.lifecycle.ViewModel

class VerificationViewModel: ViewModel(){
    var isNIKValid = true
    var isNorekValid = true
    fun validateNIK(nik: String) : Boolean {
        isNIKValid = nik.length > 16
        return isNIKValid
    }

    fun validateNorek(norek: String) : Boolean {
        isNorekValid = norek.length > 8
        return isNorekValid
    }
}