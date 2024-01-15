package com.example.icb0007_uf1_pr01_miguelnunezramon1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPIService {
    @GET("users")
    fun  getAllPosts(): Call<List<Post>>
}