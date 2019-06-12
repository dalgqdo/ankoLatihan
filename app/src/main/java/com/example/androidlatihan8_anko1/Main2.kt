package com.example.androidlatihan8_anko1

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.*

class Main2 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewLogin().setContentView(this)

        val btn: Button = findViewById(R.id.btn)
        val reg: TextView = findViewById(R.id.tv_register)
        val uname: EditText = findViewById(R.id.et_inputPass)
        val pass: EditText = findViewById(R.id.et_inputPass)

        btn.setOnClickListener {
            val nama = uname.text.toString().trim()
            val password = pass.text.toString().trim()
            handlingForLogin(nama, password)
        }

        reg.setOnClickListener {
            startActivity(intentFor<Register>())
        }
    }

    class ViewLogin : AnkoComponent<Main2> {
        override fun createView(ui: AnkoContext<Main2>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    verticalGravity = Gravity.CENTER
                    backgroundColor = R.color.colorPrimary
                }
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent) {
                        backgroundColor = Color.WHITE
                        margin = 15
                        padding = 20
                    }
                    textView {
                        text = "LOGIN"
                        textSize = 25.0f
                        textColor = Color.CYAN
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    editText {
                        hint = "input your name"
                        id = R.id.et_inputName
                        inputType = InputType.TYPE_CLASS_TEXT
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    editText {
                        hint = "input password"
                        id = R.id.et_inputPass
                        inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    button {
                        id = R.id.btn
                    }.lparams(width = wrapContent, height = wrapContent) {
                        margin = 15
                        gravity = Gravity.CENTER
                    }
                    textView {
                        text = "Register"
                        textSize = 15.0f
                        textColor = Color.BLUE
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                        id = R.id.tv_register
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }

                }
            }
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