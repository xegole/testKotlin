package com.bigthinkapps.calculator.model

import java.io.Serializable

data class UserList(
        val name: String,
        val lastName: String,
        val age: Int,
        val typeUser: Int) : Serializable