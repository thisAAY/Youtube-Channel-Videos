package com.thisaay.youtuber.di.component

import androidx.appcompat.app.AppCompatActivity
import com.thisaay.youtuber.di.ActivityScope
import com.thisaay.youtuber.di.module.ActivityModule
import com.thisaay.youtuber.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = [ApplicationComponent::class],modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}

