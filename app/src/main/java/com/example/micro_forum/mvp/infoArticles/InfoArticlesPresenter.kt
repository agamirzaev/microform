package com.example.micro_forum.mvp.infoArticles

import com.example.micro_forum.data.DataManager
import com.example.micro_forum.data.model.article.ArticleComments
import com.example.micro_forum.data.model.article.ArticleInfo
import com.example.micro_forum.mvp.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoArticlesPresenter(private val dataManager: DataManager) :
    BasePresenter<InfoArticlesContract.View>(),InfoArticlesContract.Presenter {

    private lateinit var callArticlesInfo: Call<ArticleInfo>
    private lateinit var callArticlesComments: Call<ArrayList<ArticleComments>>

    override fun loadArticlesInfo(id: String) {
        mvpView.let { it ->
            it?.showProgress()
            callArticlesInfo = dataManager.getArticlesInfo(id)
            callArticlesInfo.enqueue(object : Callback<ArticleInfo> {
                override fun onFailure(call: Call<ArticleInfo?>, t: Throwable) {
                    it?.hideProgress()
                    it?.noConnection()
                }

                override fun onResponse(
                    call: Call<ArticleInfo>,
                    response: Response<ArticleInfo>
                ) {
                    it?.hideProgress()
                    if (response.isSuccessful) {
                        response.body()?.let { res ->
                            it?.showArticles(response.body()!!)
                        }
                    }
                }
            })
        }
    }

    override fun loadCommentsArticles(id: String) {
        mvpView.let { it ->
            it?.showProgress()
            callArticlesComments = dataManager.getArticlesComments(id)
            callArticlesComments.enqueue(object : Callback<ArrayList<ArticleComments>> {

                override fun onResponse(
                    call: Call<ArrayList<ArticleComments>>,
                    response: Response<ArrayList<ArticleComments>>
                ) {
                    it?.hideProgress()
                    if (response.isSuccessful) {
                        response.body()?.let { res ->
                            it?.showArticlesComments(response.body())
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<ArticleComments>>, t: Throwable) {
                    it?.hideProgress()
                    it?.noConnection()
                }
            })
        }
    }

}