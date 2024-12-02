package com.dicoding.fitjourney.data.retrofil

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    fun register(@Body user: User): Call<ApiResponse>

    @POST("login")
    fun login(@Body user: User): Call<ApiResponse>

    @GET("account-info")
    fun getAccountInfo(): Call<AccountInfo>
}
