package com.example.micro_forum.mvp.infoUsers

import com.example.micro_forum.data.model.users.Users
import com.example.micro_forum.mvp.MvpView

interface UsersInfoContract {
    interface View : MvpView {
        fun showInfoUsers(users: Users)
        fun showProgress()
        fun hideProgress()
        fun noConnection()
    }

    interface Presenter : MvpView {
        fun loadInfoUsers(id:String)

    }
}