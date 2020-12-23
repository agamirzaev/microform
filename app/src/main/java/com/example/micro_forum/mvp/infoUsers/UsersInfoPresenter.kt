package com.example.micro_forum.mvp.infoUsers

import com.example.micro_forum.data.DataManager
import com.example.micro_forum.data.model.users.Users
import com.example.micro_forum.mvp.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersInfoPresenter(private val dataManager: DataManager) :
    BasePresenter<UsersInfoContract.View>(), UsersInfoContract.Presenter {

    private lateinit var callUsers: Call<Users>

    override fun loadInfoUsers(id: String) {
        mvpView.let { it ->
            it?.showProgress()
            callUsers = dataManager.getInfoUsers(id)
            callUsers.enqueue(object : Callback<Users> {
                override fun onFailure(call: Call<Users>, t: Throwable) {
                    it?.hideProgress()
                    it?.noConnection()
                }

                override fun onResponse(call: Call<Users>, response: Response<Users>) {
                    it?.hideProgress()
                    if (response.isSuccessful) {
                        response.body()?.let { res ->
                            it?.showInfoUsers(response.body()!!)
                        }
                    }
                }
            })
        }
    }
}