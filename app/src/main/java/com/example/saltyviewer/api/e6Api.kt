package com.example.saltyviewer.api
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface e6Api {
    @Headers("User-Agent: SaltyViewer/0.1 (By Kroren)")
    @GET("/posts.json?limit=10")
    suspend fun getPosts(): Response<Posts>
}