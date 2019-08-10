package com.thisaay.youtuber.di.module

import com.thisaay.youtuber.BuildConfig
import com.thisaay.youtuber.YoutuberApplication
import com.thisaay.youtuber.data.remote.NetworkService
import com.thisaay.youtuber.data.remote.Networking
import com.thisaay.youtuber.utils.log.Logger
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application : YoutuberApplication) {

    @Provides
    @Singleton
    fun provideNetworkService() : NetworkService {
        return Networking.create(
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024
        )
    }

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
}