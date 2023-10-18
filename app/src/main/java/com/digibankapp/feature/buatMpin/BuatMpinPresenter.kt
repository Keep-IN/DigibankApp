package com.digibankapp.feature.buatMpin

class BuatMpinPresenter (
    private val view: BuatMpinContract
){
    private var isMpinValid = false
    private var isMpinEqual = false

    fun validateMpin(mPin: String): Boolean {
        //validasi mpin 6 angka
        isMpinValid = mPin.length in 5..7

        if(isMpinValid){
            view.onErrorSuccess(1, "")
        } else {
            view.onError(1, "MPIN harus terdiri dari 6 digit")
        }
        return isMpinValid
    }

    fun validateReMpin(mPin: String, reMpin: String): Boolean {
        ///validate rempin sama dengan mpin
        isMpinEqual = reMpin.equals(mPin)

        if(isMpinEqual){
            view.onErrorSuccess(2, "")
        } else {
            view.onError(2, "MPIN tidak sama")
        }
        return isMpinEqual
    }
}