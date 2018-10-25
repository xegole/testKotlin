package com.bigthinkapps.calculator.entity

import com.google.gson.annotations.SerializedName

data class File(val name: String, val status: String, @SerializedName("content_type") val contentType: String)