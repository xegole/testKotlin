package com.bigthinkapps.calculator.services

import com.bigthinkapps.calculator.services.api.RetrofitApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServices {

    private const val BASE_URL = "https://api.openload.co/1/"

    fun create(): RetrofitApi {

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

        return retrofit.create(RetrofitApi::class.java)
    }
}