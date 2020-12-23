package com.example.micro_forum.mvp

open class BasePresenter<T : MvpView?> : MvpPresenter<T> {
    var mvpView: T? = null
        private set

    override fun attachView(view: T) {
        mvpView = view
    }

    override fun detachView() {
        mvpView = null
    }
}