package com.example.saltyviewer.api.image

data class File(
    val width: Int,
    val height: Int,
    val ext: String, // The image extension
    val size: Int, // Size in bytes
    val md5: String,
    val url: String
)