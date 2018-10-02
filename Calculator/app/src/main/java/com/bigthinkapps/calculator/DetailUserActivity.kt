package com.bigthinkapps.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bigthinkapps.calculator.model.UserList
import kotlinx.android.synthetic.main.activity_detail_user.*


class DetailUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val userExtra = intent.extras.getSerializable("user_list_extra") as UserList
        initToolBar(userExtra.name)
    }


    private fun initToolBar(title: String) {
        toolbar.title = title

        setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}
