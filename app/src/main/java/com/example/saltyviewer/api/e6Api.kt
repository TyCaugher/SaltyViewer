package com.example.saltyviewer.api
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface e6Api {

    // Search format: posts.json? tags=order:score+dragon+rating:s &limit=5
    @Headers("User-Agent: SaltyViewer/0.1 (By Kroren)")
    @GET("/posts.json?tags=")
    suspend fun getPosts(@Query("tags") tags: List<String>?, @Query("page") page: Int): Response<Posts>
}