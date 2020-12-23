package com.example.micro_forum.data.model

import com.google.gson.annotations.SerializedName

class ArticleComments {
    @SerializedName("postId")
    private var postId: Int = 0

    @SerializedName("id")
    private var id: Int = 0

    @SerializedName("name")
    private lateinit var name: String

    @SerializedName("email")
    private lateinit var email: String

    @SerializedName("body")
    private lateinit var body: String

    fun getPostId(): Int? {
        return postId
    }

    fun setPostId(postId: Int?) {
        this.postId = postId!!
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id!!
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name!!
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email!!
    }

    fun getBody(): String? {
        return body
    }

    fun setBody(body: String?) {
        this.body = body!!
    }

}