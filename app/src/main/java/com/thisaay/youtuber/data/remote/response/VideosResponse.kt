package com.thisaay.youtuber.data.remote.response

import com.thisaay.youtuber.data.model.api.VideoApi
import com.thisaay.youtuber.data.model.api.PageInfo

data class VideosResponse(
    val etag: String,
    val items: List<VideoApi>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo,
    val regionCode: String
)