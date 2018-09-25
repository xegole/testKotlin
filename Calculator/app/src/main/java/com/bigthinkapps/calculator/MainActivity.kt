package com.bigthinkapps.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener { onClickButton() }

        labelLogin.setOnClickListener {
            Toast.makeText(this, "click over label", Toast.LENGTH_SHORT).show()
            inputMessage.setText("empty value")
        }
    }

    private fun onClickButton() {
        val message = inputMessage.text
        Toast.makeText(this, "this is a message", Toast.LENGTH_SHORT).show()
        labelLogin.text = message
    }
}
