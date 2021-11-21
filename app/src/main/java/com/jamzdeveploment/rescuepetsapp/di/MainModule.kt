package com.jamzdeveploment.rescuepetsapp.di

import android.app.Activity
import com.jamzdeveploment.rescuepetsapp.model.MainInteractor
import com.jamzdeveploment.rescuepetsapp.model.MainInteractorImpl
import com.jamzdeveploment.rescuepetsapp.presenter.MainPresenter
import com.jamzdeveploment.rescuepetsapp.presenter.MainPresenterImpl
import com.jamzdeveploment.rescuepetsapp.view.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule {

    /* @Binds
     abstract fun bindMainActivity(
         mainActivity: MainActivity
     ): MainView*/

    @Binds
    abstract fun bindMainPresenter(
        mainPresenterImpl: MainPresenterImpl
    ): MainPresenter


    @Binds
    abstract fun bindMainInteractor(
        mainInteractorImpl: MainInteractorImpl
    ): MainInteractor
}

@InstallIn(ActivityComponent::class)
@Module
object MainActivityModule {

    @Provides
    fun bindActivity(activity: Activity): MainActivity {
        return activity as MainActivity
    }
}