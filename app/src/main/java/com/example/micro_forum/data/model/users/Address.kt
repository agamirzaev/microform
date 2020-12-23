package com.example.micro_forum.data.model.users

import com.google.gson.annotations.SerializedName

class Address {
    @SerializedName("street")
    private lateinit var street: String

    @SerializedName("suite")
    private lateinit var suite: String

    @SerializedName("city")
    private lateinit var city: String

    @SerializedName("zipcode")
    private lateinit var zipcode: String

    @SerializedName("geo")
    private lateinit var geo: Geo

    fun getStreet(): String? {
        return street
    }

    fun setStreet(street: String?) {
        this.street = street!!
    }

    fun getSuite(): String? {
        return suite
    }

    fun setSuite(suite: String?) {
        this.suite = suite!!
    }

    fun getCity(): String? {
        return city
    }

    fun setCity(city: String?) {
        this.city = city!!
    }

    fun getZipcode(): String? {
        return zipcode
    }

    fun setZipcode(zipcode: String?) {
        this.zipcode = zipcode!!
    }

    fun getGeo(): Geo? {
        return geo
    }

    fun setGeo(geo: Geo?) {
        this.geo = geo!!
    }
}