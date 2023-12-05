package com.example.steamsaleapp

import android.app.Application
import com.example.steamsaleapp.data.DefaultSteamContainer
import com.example.steamsaleapp.data.SteamContainer

class SteamSaleApplication : Application() {
    lateinit var container: SteamContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultSteamContainer()
    }
}