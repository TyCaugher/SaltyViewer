package com.example.saltyviewer.api

data class Tags(
    val general: List<String>,
    val species: List<String>,
    val character: List<String>,
    val copyright: List<String>,
    val artist: List<String>,
    val invalid: List<String>,
    val lore: List<String>,
    val meta: List<String>
)