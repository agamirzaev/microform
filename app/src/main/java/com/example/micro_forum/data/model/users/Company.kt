package com.example.micro_forum.data.model.users

import com.google.gson.annotations.SerializedName

class Company {
    @SerializedName("name")
    private lateinit  var name: String

    @SerializedName("catchPhrase")
    private lateinit var catchPhrase: String

    @SerializedName("bs")
    private lateinit var bs: String

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name!!
    }

    fun getCatchPhrase(): String? {
        return catchPhrase
    }

    fun setCatchPhrase(catchPhrase: String?) {
        this.catchPhrase = catchPhrase!!
    }

    fun getBs(): String? {
        return bs
    }

    fun setBs(bs: String?) {
        this.bs = bs!!
    }
}