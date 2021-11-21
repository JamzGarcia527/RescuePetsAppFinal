package com.jamzdeveploment.rescuepetsapp.presenter

import com.jamzdeveploment.rescuepetsapp.entities.UserDataCollectionItem
import com.jamzdeveploment.rescuepetsapp.model.DefaultObserver
import com.jamzdeveploment.rescuepetsapp.model.MainInteractor
import com.jamzdeveploment.rescuepetsapp.view.MainActivity
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val view: MainActivity,
    private val interactor: MainInteractor
) : MainPresenter {

    override fun listUsers() {
        interactor.listUsers(MainObserver())
    }

    inner class MainObserver : DefaultObserver<List<UserDataCollectionItem>>() {

        override fun onNext(t: List<UserDataCollectionItem>?) {
            dispose()
            view?.showResult(t!!)
        }

        override fun onError(e: Throwable?) {
            view?.errorResult(e?.message.toString())
        }
    }

}