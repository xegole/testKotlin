package com.bigthinkapps.calculator

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val handler by lazy { Handler() }
    private var handlerLate: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handlerLate.postDelayed({ goToMainScreen() }, 3000)
    }

    private fun goToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
