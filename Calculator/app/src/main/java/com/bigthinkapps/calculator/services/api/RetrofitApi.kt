package com.bigthinkapps.calculator.services.api

import com.bigthinkapps.calculator.entity.GetFilesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {

    @GET("file/listfolder")
    fun getListFiles(@Query("login") apiLogin: String, @Query("key") apiKey: String): Observable<GetFilesResponse>

}