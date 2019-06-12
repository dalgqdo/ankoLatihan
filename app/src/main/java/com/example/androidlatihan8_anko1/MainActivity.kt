package com.example.androidlatihan8_anko1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val username = et_username.text.toString().trim()
            val password = et_password.text.toString().trim()
            handlingForLogin(username, password)
        }

        tv_register.setOnClickListener {
            toast("Pindah Ke Halaman Register")
            startActivity(intentFor<Register>())
        }
    }

    private fun handlingForLogin(uname: String, pass: String) {
        info { "username = $uname ,  password = $pass" }
        if (uname.equals("master") && pass.equals("master123")) {
            toast("welcome $uname")
        } else {
            alert(title = "Warning", message = "uname or pass wrong") {
                positiveButton(buttonText = "ok") {

                }
                isCancelable = false
            }.show()
        }
    }
}
