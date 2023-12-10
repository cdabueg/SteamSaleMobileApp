package com.example.steamsaleapp

import android.app.Application
import com.example.steamsaleapp.data.DefaultSteamGameContainer
import com.example.steamsaleapp.data.DefaultSteamGamesListContainer
import com.example.steamsaleapp.data.SteamGameContainer
import com.example.steamsaleapp.data.SteamGamesListContainer

class SteamSaleApplication : Application() {
    lateinit var listContainer: SteamGamesListContainer
    lateinit var gameContainer: SteamGameContainer
    override fun onCreate() {
        super.onCreate()
        listContainer = DefaultSteamGamesListContainer()
        gameContainer = DefaultSteamGameContainer()
    }
}