package com.bigthinkapps.calculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bigthinkapps.calculator.model.User
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val user by lazy { userExtra }
    private lateinit var userExtra: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userExtra = intent.extras.getSerializable("extra_user") as User
        //here assigned variable user
        textUsername.setText(user.username)

        val platform = intent.extras.getString("extra_platform") as String
        labelPlatform.text = platform

        btnMain.setOnClickListener { goToMainScreen() }
    }

    private fun goToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        MainActivity.TAG
    }
}
