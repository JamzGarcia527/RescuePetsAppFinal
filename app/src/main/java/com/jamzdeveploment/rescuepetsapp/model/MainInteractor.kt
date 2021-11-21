package com.jamzdeveploment.rescuepetsapp.model

import com.jamzdeveploment.rescuepetsapp.entities.UserDataCollectionItem
import io.reactivex.rxjava3.core.Observer

interface MainInteractor {

    fun listUsers(subscriber: Observer<List<UserDataCollectionItem>>)
}