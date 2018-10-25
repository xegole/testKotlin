package com.bigthinkapps.calculator.entity

import com.google.gson.annotations.SerializedName

data class GetFilesResponse(
        @SerializedName("status") val statusCode: Int,
        @SerializedName("msg") val message: String,
        val dialog: String,
        @SerializedName("result") val listFolders: ListFolders)