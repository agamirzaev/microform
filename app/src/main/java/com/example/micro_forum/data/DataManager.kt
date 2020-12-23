package com.example.micro_forum.data

import com.example.micro_forum.data.model.article.Article
import com.example.micro_forum.data.model.article.ArticleComments
import com.example.micro_forum.data.model.article.ArticleInfo
import com.example.micro_forum.data.model.users.Users
import com.example.micro_forum.data.remote.Api
import com.example.micro_forum.data.remote.ServicesGenerator
import retrofit2.Call

class DataManager {
    private val api = ServicesGenerator.createService(Api::class.java)

    fun getArticlesList(): Call<ArrayList<Article>> {
        return api.articlesList()
    }

    fun getArticlesInfo(id: String): Call<ArticleInfo> {
        return api.articlesInfo(id)
    }

    fun getArticlesComments(id: String): Call<ArrayList<ArticleComments>> {
        return api.articlesComments(id)
    }

    fun getInfoUsers(id: String): Call<Users> {
        return api.usersInfo(id)
    }
}