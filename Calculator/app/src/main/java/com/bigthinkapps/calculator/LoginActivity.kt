package com.bigthinkapps.calculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bigthinkapps.calculator.adapter.UsersAdapter
import com.bigthinkapps.calculator.model.User
import com.bigthinkapps.calculator.model.UserList
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

    private fun getUserList(): ArrayList<UserList> {
        val userList = ArrayList<UserList>()
        val user = UserList("diego", "leon", 28, TYPE_USER)
        val admin = UserList("fernando", "puerta", 28, TYPE_ADMIN)
        val user2 = UserList("pedro", "contreras", 32, TYPE_USER)

        userList.add(user)
        userList.add(admin)
        userList.add(user2)
        return userList
    }

    companion object {
        const val TYPE_USER = 101
        const val TYPE_ADMIN = 102
    }
}
