package com.jamzdeveploment.rescuepetsapp.view

import com.jamzdeveploment.rescuepetsapp.entities.UserDataCollectionItem

interface MainView {

    fun showResult(result: List<UserDataCollectionItem>)
    fun errorResult(t: String)
}