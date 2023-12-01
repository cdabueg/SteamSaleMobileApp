package com.example.steamsaleapp

import android.app.Application
import com.example.steamsaleapp.data.MarsAppContainer
import com.example.steamsaleapp.data.DefaultMarsAppContainer

class MarsPhotosApplication : Application() {
    lateinit var container: MarsAppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultMarsAppContainer()
    }
}