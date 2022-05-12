package com.example.saltyviewer.api

data class Posts(
    val page: Int,
    val posts: List<Post>
)