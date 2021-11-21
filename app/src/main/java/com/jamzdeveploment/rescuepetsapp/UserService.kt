package com.jamzdeveploment.rescuepetsapp

import com.jamzdeveploment.rescuepetsapp.entities.UserDataCollectionItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface UserService {
    @GET("users")
    fun listUsers(): Observable<List<UserDataCollectionItem>>
}