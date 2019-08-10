package com.thisaay.youtuber.data.mapper

import com.thisaay.youtuber.data.model.Video
import com.thisaay.youtuber.data.model.api.VideoApi
import com.thisaay.youtuber.utils.log.Logger

object VideoMapper {
    const val TAG = "VideoMapper"
    fun map(v: VideoApi): Video =
        Video(
            v.id?.videoId.toString(),
            v.snippet.publishedAt,
            v.snippet.title,
            v.snippet.description,
            v.snippet.thumbnails.high.url
        )

    fun map(vs: List<VideoApi>): List<Video> {
        val videos = mutableListOf<Video>()
        for (i in 0 until vs.size)
            videos.add(map(vs[i]))
        return videos

    }


}