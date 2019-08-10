package com.thisaay.youtuber.data.model.api

data class Snippet(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val liveBroadcastContent: String,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String
)