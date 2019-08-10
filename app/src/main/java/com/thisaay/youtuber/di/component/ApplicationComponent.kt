package com.thisaay.youtuber.di.component

import com.thisaay.youtuber.YoutuberApplication
import com.thisaay.youtuber.data.remote.NetworkService
import com.thisaay.youtuber.di.module.ApplicationModule
import dagger.Component
import dagger.Module
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton



@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app :YoutuberApplication)

    fun getNetworkService() : NetworkService

    fun getCompositeDisposable() : CompositeDisposable
}