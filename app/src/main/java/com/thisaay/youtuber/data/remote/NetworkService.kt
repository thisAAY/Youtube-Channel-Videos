package com.thisaay.youtuber.data.remote

import com.thisaay.youtuber.data.remote.response.VideosResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET(Endpoints.VIDEOS)
    fun doVideosListCall(
        @Query("key") key : String?,
        @Query("channelId") channelId : String?,
        @Query("maxResults") maxResults : String?
    ): Single<VideosResponse>

    @GET(Endpoints.VIDEOS)
    fun doNextVideosListCall(
        @Query("pageToken") pageToken :String?,
        @Query("key") key : String?,
        @Query("channelId") channelId : String?,
        @Query("maxResults") maxResults : String?
    ): Single<VideosResponse?>
}