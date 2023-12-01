package com.example.steamsaleapp

import android.app.Application
import com.example.steamsaleapp.data.DefaultSteamAppContainer
import com.example.steamsaleapp.data.SteamAppContainer

class SteamSaleApplication : Application() {
    lateinit var container: SteamAppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultSteamAppContainer()
    }
}