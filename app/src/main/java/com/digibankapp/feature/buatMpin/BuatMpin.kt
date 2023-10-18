package com.digibankapp.feature.buatMpin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.core.widget.doOnTextChanged
import com.digibankapp.R
import com.digibankapp.databinding.ActivityBuatMpinBinding

class BuatMpin : AppCompatActivity(), BuatMpinContract {

    private lateinit var binding: ActivityBuatMpinBinding
    private lateinit var presenter: BuatMpinPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBuatMpinBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSimpan.isEnabled = false

        binding.ivBackMpin.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        binding.tilMpin.editText?.doOnTextChanged{ text, start, before, count -> validateInput()
            presenter.validateMpin(binding.tilMpin.editText?.text.toString())
        }

        binding.tilKonfirmMpin.editText?.doOnTextChanged{ text, start, before, count -> validateInput()
            presenter.validateReMpin(binding.tilMpin.editText?.text.toString(), binding.tilKonfirmMpin.editText?.text.toString())
        }
    }

    override fun onError(code: Int, message: String){
        when(code){
            1 -> binding.tilMpin.error = message
            2 -> binding.tilKonfirmMpin.error = message
        }
    }

    override fun onErrorSuccess(code: Int, message: String){
        when(code){
            1 -> binding.tilMpin.isErrorEnabled = false
            2 -> binding.tilKonfirmMpin.isErrorEnabled = false
        }
    }

    private fun validateInput(){
        binding.btnSimpan.isEnabled =
        binding.tilMpin.editText?.text.toString().isNotBlank() &&
        binding.tilKonfirmMpin.editText?.text.toString().isNotBlank()
    }
}