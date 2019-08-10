package com.thisaay.youtuber.data.model

data class Video(
    val id: String,
    val publishedAt: String,
    val title: String,
    val description: String,
    val thumbnailUrl: String
    ) {
    fun getVideoUrl() : String?= "https://www.youtube.com/watch?v=$id"
}