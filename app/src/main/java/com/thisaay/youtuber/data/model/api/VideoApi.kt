package com.thisaay.youtuber.data.model.api

data class VideoApi(
    val etag: String,
    val id: Id?,
    val kind: String,
    val snippet: Snippet
)