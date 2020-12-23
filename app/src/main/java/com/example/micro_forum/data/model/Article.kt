package com.example.micro_forum.data.model

import com.google.gson.annotations.SerializedName

class Article {
    @SerializedName("userId")
    private var userId: Int = 0

    @SerializedName("id")
    private var id: Int = 0

    @SerializedName("title")
    private lateinit var title: String

    @SerializedName("body")
    private lateinit var body: String

    fun getUserId(): Int? {
        return userId
    }

    fun setUserId(userId: Int?) {
        this.userId = userId!!
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id!!
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title!!
    }

    fun getBody(): String? {
        return body
    }

    fun setBody(body: String?) {
        this.body = body!!
    }
}