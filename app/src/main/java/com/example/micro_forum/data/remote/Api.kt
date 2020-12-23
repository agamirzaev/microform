package com.example.micro_forum.data.remote

import com.example.micro_forum.data.model.article.Article
import com.example.micro_forum.data.model.article.ArticleComments
import com.example.micro_forum.data.model.article.ArticleInfo
import com.example.micro_forum.data.model.users.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("posts/")
    fun articlesList(): Call<ArrayList<Article>>

    @GET("posts/{id}")
    fun articlesInfo(@Path("id") id: String): Call<ArticleInfo>

    @GET("posts/{id}/comments")
    fun articlesComments(@Path("id") id: String): Call<ArrayList<ArticleComments>>

    @GET("users/{id}")
    fun usersInfo(@Path("id") id: String): Call<Users>
}