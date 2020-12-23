package com.example.micro_forum.mvp.infoArticles

import com.example.micro_forum.data.model.ArticleComments
import com.example.micro_forum.data.model.ArticleInfo
import com.example.micro_forum.mvp.MvpView

interface InfoArticlesContract {
    interface View : MvpView {

        fun showArticles(articlesInfo: ArticleInfo)
        fun showArticlesComments(articlesComments: ArrayList<ArticleComments>?)
        fun showProgress()
        fun hideProgress()
        fun noConnection()
    }

    interface Presenter : MvpView {

        fun loadCommentsArticles(id: String)
        fun loadArticlesInfo(id: String)

    }
}