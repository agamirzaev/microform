package com.example.micro_forum.data.model.users

import com.google.gson.annotations.SerializedName

class Users {
    @SerializedName("id")
    private var id: Int = 0

    @SerializedName("name")
    private lateinit var name: String

    @SerializedName("username")
    private lateinit var username: String

    @SerializedName("email")
    private lateinit var email: String

    @SerializedName("address")
    private lateinit var address: Address

    @SerializedName("phone")
    private lateinit var phone: String

    @SerializedName("website")
    private lateinit var website: String

    @SerializedName("company")
    private lateinit var company: Company

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

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String?) {
        this.username = username!!
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email!!
    }

    fun getAddress(): Address? {
        return address
    }

    fun setAddress(address: Address?) {
        this.address = address!!
    }

    fun getPhone(): String? {
        return phone
    }

    fun setPhone(phone: String?) {
        this.phone = phone!!
    }

    fun getWebsite(): String? {
        return website
    }

    fun setWebsite(website: String?) {
        this.website = website!!
    }

    fun getCompany(): Company? {
        return company
    }

    fun setCompany(company: Company?) {
        this.company = company!!
    }
}