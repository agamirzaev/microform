package com.example.micro_forum.mvp.allArticles

import com.example.micro_forum.data.DataManager
import com.example.micro_forum.data.model.article.Article
import com.example.micro_forum.mvp.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesPresenter (private val dataManager: DataManager) :
    BasePresenter<ArticlesContract.View>(),
    ArticlesContract.Presenter {

    private lateinit var callArticles: Call<ArrayList<Article>>

    override fun loadArticlesInfo() {
        mvpView.let { it ->
            it?.showProgress()
            callArticles = dataManager.getArticlesList()
            callArticles.enqueue(object : Callback<ArrayList<Article>> {

                override fun onResponse(
                    call: Call<ArrayList<Article>>,
                    response: Response<ArrayList<Article>>
                ) {
                    it?.hideProgress()
                    if (response.isSuccessful) {
                        response.body()?.let { res ->
                            it?.showArticles(response.body()!!)
                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<Article>>, t: Throwable) {
                    it?.hideProgress()
                    it?.noConnection()
                }
            })
        }
    }
}