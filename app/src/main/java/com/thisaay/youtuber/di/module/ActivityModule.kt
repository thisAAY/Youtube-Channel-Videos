package com.thisaay.youtuber.di.module


import androidx.lifecycle.ViewModelProviders
import com.thisaay.youtuber.data.remote.NetworkService
import com.thisaay.youtuber.ui.MainActivity
import com.thisaay.youtuber.ui.MainViewModel
import com.thisaay.youtuber.utils.ViewModelProviderFactory
import com.thisaay.youtuber.utils.common.Resource
import com.thisaay.youtuber.utils.log.Logger
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: MainActivity) {


    @Provides
    fun provideMainViewModel(compositeDisposable: CompositeDisposable, networkService: NetworkService): MainViewModel =
        ViewModelProviders.of(
            activity, ViewModelProviderFactory(MainViewModel::class) {
                MainViewModel(compositeDisposable, networkService)
            }).get(MainViewModel::class.java)

    @Provides
    fun provideRes() : Resource<String> {

        return Resource.success("AAY")
    }
}
