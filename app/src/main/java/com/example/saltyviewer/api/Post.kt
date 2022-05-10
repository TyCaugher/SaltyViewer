package com.example.saltyviewer.api

import com.example.saltyviewer.api.image.File
import com.example.saltyviewer.api.image.Preview
import com.example.saltyviewer.api.image.Sample

data class Post(
    val id: Int,
    val dateUploaded: String,
    // Image data
    val file: File,
    val preview: Preview,
    val sample: Sample,
    //Score data
    val score: Score,
    //tags
    val tags: Tags,
    // Other info
    val rating: String,
    val fav_count: Int,
    val sources: List<String>,
    val pools: List<Int>,

    val description: String
    // IsFavorited
    )