package com.jamzdeveploment.rescuepetsapp.model



import com.jamzdeveploment.rescuepetsapp.RestEngine
import com.jamzdeveploment.rescuepetsapp.UserService
import com.jamzdeveploment.rescuepetsapp.entities.UserDataCollectionItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class MainInteractorImpl @Inject constructor(
) : MainInteractor {

    override fun listUsers(subscriber: Observer<List<UserDataCollectionItem>>) {
        RestEngine.getRestEngine().create(UserService::class.java).listUsers()
            .subscribeOn(Schedulers.newThread())
            .map { it.filter { it.address.city == "South Elvis" } }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(subscriber)
    }

}