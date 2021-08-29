package com.example.mynewsapp.model

data class News (
    val author : String,
    val title : String,
    val description : String,
    val publishedAt : String,
    val urlToImage: String,
    val link : String
)