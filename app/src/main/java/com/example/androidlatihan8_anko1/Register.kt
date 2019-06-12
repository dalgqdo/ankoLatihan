package com.example.androidlatihan8_anko1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_act.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast

class Register : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_act)

        btn_reg.setOnClickListener {
            val name = et_inputName.text.toString().trim()
            val pass = et_inputPass.text.toString().trim()
            handlingForRegister(name, pass)
        }
    }

    private fun handlingForRegister(uname: String, pass: String) {
        when {
            uname.isEmpty() -> toast("username kosong")
            pass.isEmpty() -> toast("password kosong")
            else -> alert(title = "REGISTRASI", message = "REGSITRASI SUKSES") {
                positiveButton(buttonText = "OK") {
                    onBackPressed()
                    finish()
                }
                isCancelable = false
            }.show()
        }
    }

}