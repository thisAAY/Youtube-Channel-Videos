package com.thisaay.youtuber

import android.app.Application
import com.thisaay.youtuber.data.remote.NetworkService
import com.thisaay.youtuber.di.component.ApplicationComponent
import com.thisaay.youtuber.di.component.DaggerApplicationComponent
import com.thisaay.youtuber.di.module.ApplicationModule
import javax.inject.Inject

class YoutuberApplication : Application()
{
    @Inject
    lateinit var networkService: NetworkService

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }
    private fun injectDependencies()
    {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}