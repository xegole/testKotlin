package com.bigthinkapps.calculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bigthinkapps.calculator.Utils.jsonData
import com.bigthinkapps.calculator.adapter.UsersAdapter
import com.bigthinkapps.calculator.entity.GetAllCommercesResponse
import com.bigthinkapps.calculator.model.Store
import com.bigthinkapps.calculator.model.User
import com.bigthinkapps.calculator.model.UserList
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val user by lazy { userExtra }
    private lateinit var userExtra: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userExtra = intent.extras.getSerializable("extra_user") as User
        //user = userExtra
        textUsername.setText(user.username)

        val platform = intent.extras.getString("extra_platform") as String
        labelPlatform.text = platform

        val adapter = UsersAdapter(ArrayList())
        recyclerUsers.adapter = adapter
        recyclerUsers.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false)

        btnMain.setOnClickListener { adapter.addMoreItems(getUserList()) }
    }



    private fun goToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        MainActivity.TAG
    }

    private fun getUserList(): ArrayList<Store> {
        val allCommercesResponse = Gson().fromJson(jsonData, GetAllCommercesResponse::class.java)
        return allCommercesResponse.result
    }

    companion object {
        const val TYPE_USER = 101
        const val TYPE_ADMIN = 102
    }
}
