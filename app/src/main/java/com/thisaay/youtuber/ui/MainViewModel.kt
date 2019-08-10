package com.thisaay.youtuber.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mindorks.bootcamp.instagram.utils.rx.RxSchedulerProvider
import com.thisaay.youtuber.BuildConfig
import com.thisaay.youtuber.data.mapper.VideoMapper
import com.thisaay.youtuber.data.model.Video
import com.thisaay.youtuber.data.model.api.VideoApi
import com.thisaay.youtuber.data.remote.NetworkService
import com.thisaay.youtuber.utils.common.Resource
import com.thisaay.youtuber.utils.log.Logger
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    private val compositeDisposable: CompositeDisposable,
    private val networkService: NetworkService
) : ViewModel() {


    private var nextPageToken: String? = null
    companion object {
        const val TAG = "MainViewModel"
    }

    val videos = MutableLiveData<Resource<List<Video>>>()

    fun getVideos() {
        compositeDisposable.add(
            networkService.doVideosListCall(
                BuildConfig.API_KEY,
                BuildConfig.CHANNEL_ID,
                "50"
            )
                .map { v ->
                    nextPageToken = v.nextPageToken
                    Logger.d(TAG,nextPageToken.toString())
                    return@map VideoMapper.map(v. items)
                }
                .subscribeOn(RxSchedulerProvider.io())
                .observeOn(RxSchedulerProvider.ui())
                .subscribe({
                    videos.postValue(Resource.success(it))
                }, {
                    Logger.e(TAG, "getVideos", it)
                })
        )
    }
    fun getNextVideos() : Boolean
    {
        if(nextPageToken == null)
            return false
        compositeDisposable.add(
            networkService.doNextVideosListCall(
                nextPageToken,
                BuildConfig.API_KEY,
                BuildConfig.CHANNEL_ID,
                "50"
            )
                .map { v ->
                    nextPageToken = v.nextPageToken
                    Logger.d(TAG,nextPageToken.toString())
                    return@map VideoMapper.map(v.items)
                }
                .subscribeOn(RxSchedulerProvider.io())
                .observeOn(RxSchedulerProvider.ui())
                .subscribe({
                    videos.postValue(Resource.success(it))
                }, {
                    Logger.e(TAG, "getVideos", it)
                })
        )
        return true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}