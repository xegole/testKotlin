package com.bigthinkapps.calculator

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calc = Calculator()

        labelTest.text = "This is"
        labelTest.setTextColor(Color.BLUE)

        btnOperation.setOnClickListener { labelTest.text = calc.mult(2, 3).toString() }
    }
}
