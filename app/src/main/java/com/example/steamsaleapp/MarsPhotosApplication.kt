package com.example.steamsaleapp

import android.app.Application
import com.example.steamsaleapp.data.AppContainer
import com.example.steamsaleapp.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}