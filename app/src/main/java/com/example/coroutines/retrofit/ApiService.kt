package com.example.coroutines.retrofit

import com.example.coroutines.model.GithubUser
import com.example.coroutines.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    suspend fun getUsersFromJsoPlaceHolder(): List<User>

    @GET("users")
    suspend fun getUsersFromGithub(): List<GithubUser>



}