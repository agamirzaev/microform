package com.example.micro_forum.mvp

interface MvpPresenter<V : MvpView?> {
    fun attachView(view: V)
    fun detachView()
}