package com.dicoding.fitjourney.data.retrofil

data class User(
    val username: String,
    val password: String,
    val fullname: String? = null,
    val birthday: String? = null,
    val height: Float? = null,
    val weight: Float? = null,
    val activityLevel: String? = null,
    val goal: String? = null
)
