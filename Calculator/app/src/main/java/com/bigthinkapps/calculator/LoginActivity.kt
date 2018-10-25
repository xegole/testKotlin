package com.bigthinkapps.calculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.bigthinkapps.calculator.Utils.jsonData
import com.bigthinkapps.calculator.adapter.UsersAdapter
import com.bigthinkapps.calculator.entity.GetAllCommercesResponse
import com.bigthinkapps.calculator.entity.ListFolders
import com.bigthinkapps.calculator.model.Store
import com.bigthinkapps.calculator.model.User
import com.bigthinkapps.calculator.services.RetrofitServices
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val user by lazy { userExtra }
    private lateinit var userExtra: User

    val retrofitService by lazy {
        RetrofitServices.create()
    }

    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userExtra = intent.extras.getSerializable("extra_user") as User
        //user = userExtra
//        textUsername.setText(user.username)
//
//        val platform = intent.extras.getString("extra_platform") as String
//        labelPlatform.text = platform

        adapter = UsersAdapter(ArrayList())
        recyclerUsers.adapter = adapter
        recyclerUsers.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false)

        btnMain.setOnClickListener { getListFiles() }//adapter.addMoreItems(getUserList()) }

    }

    private fun getListFiles() {
//                        .subscribe(
//                                { result -> showResult(result.query.searchinfo.totalhits) },
//                                { error -> showError(error.message) }
//                        )

        progressBar.visibility = View.VISIBLE
        val apiLogin = "1f8dfedbacec3752"
        val apiKey = "lWltosYC"
        retrofitService.getListFiles(apiLogin, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response -> showListFolders(response.message, response.listFolders) },
                        { error -> Log.d("NetworkTestKotlin", error.localizedMessage) },
                        { progressBar.visibility = View.GONE }
                )
    }

    private fun showListFolders(message: String, listFolders: ListFolders) {
        Log.d("NetworkTestKotlin", message)

        for (folder in listFolders.folders) {
            Log.d("NetworkTestKotlin", folder.name)
        }
        adapter.addMoreItems(listFolders.files)
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
