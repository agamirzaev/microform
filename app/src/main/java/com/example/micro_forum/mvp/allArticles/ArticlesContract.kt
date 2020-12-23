package com.example.micro_forum.mvp.allArticles

import com.example.micro_forum.data.model.Article
import com.example.micro_forum.mvp.MvpView

interface ArticlesContract : MvpView {

    interface View : MvpView {
        fun showArticles(articles: ArrayList<Article>)
        fun showProgress()
        fun hideProgress()
        fun noConnection()
    }

    interface Presenter : MvpView {
        fun loadArticlesInfo()

    }
}