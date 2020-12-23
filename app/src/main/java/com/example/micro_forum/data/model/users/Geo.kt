package com.example.micro_forum.data.model.users

import com.google.gson.annotations.SerializedName

class Geo {
    @SerializedName("lat")
    private lateinit var lat: String

    @SerializedName("lng")
    private lateinit var lng: String

    fun getLat(): String? {
        return lat
    }

    fun setLat(lat: String?) {
        this.lat = lat!!
    }

    fun getLng(): String? {
        return lng
    }

    fun setLng(lng: String?) {
        this.lng = lng!!
    }
}