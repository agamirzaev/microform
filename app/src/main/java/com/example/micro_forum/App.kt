package com.example.micro_forum

import android.app.Application
import com.example.micro_forum.data.DataManager

class App : Application() {
    var dataManager: DataManager? = null
    override fun onCreate() {
        super.onCreate()
        dataManager = DataManager()
    }
}