package com.thisaay.youtuber.data.remote

import android.provider.SyncStateContract
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.thisaay.youtuber.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import java.io.IOException


object Networking {

    private const val CALL_TIME_OUT :Long = 60

    fun create(baseUrl:String, cacheDirectory : File, cacheSize : Long) : NetworkService
    {
         return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(OkHttpClient.Builder()
                .cache(Cache(cacheDirectory,cacheSize))
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if(BuildConfig.DEBUG)  HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                })
                .writeTimeout(CALL_TIME_OUT,TimeUnit.SECONDS)
                .readTimeout(CALL_TIME_OUT,TimeUnit.SECONDS)
                .build()
            )
             .addConverterFactory(GsonConverterFactory.create())
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .build()
             .create(NetworkService::class.java)
    }

}