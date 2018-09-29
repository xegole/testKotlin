package com.bigthinkapps.calculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bigthinkapps.calculator.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener { goToLoginScreen() }
    }

    private fun goToLoginScreen() {
        val password = textPassword.text.toString()

        if (password == PASS_VALID) {
            val intent = Intent(this, LoginActivity::class.java)
            val bundle = Bundle()

            bundle.putSerializable("extra_user", getUser())
            bundle.putString("extra_platform", "android")

            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        } else {
            textPassword.error = "wrong password"
        }
    }

    private fun getUser(): User {
        val username = textUsername.text.toString()
        val password = textPassword.text.toString()
        return User(username, password)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        const val TAG = "LogMainActivity"
        const val PASS_VALID = "12345"
    }
}
