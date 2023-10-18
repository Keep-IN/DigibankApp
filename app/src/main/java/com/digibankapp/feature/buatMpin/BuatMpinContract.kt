package com.digibankapp.feature.buatMpin

interface BuatMpinContract {
    fun onErrorSuccess(code: Int, message: String)
    fun onError(code: Int, message: String)
}