package com.example.steamsaleapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.steamsaleapp.model.App
import com.example.steamsaleapp.model.GamesList
import com.example.steamsaleapp.network.GamesListManager

@Composable
fun Games(gamesListManager: GamesListManager){
//    Log.i("API_Response", gamesListManager.gamesListResponse.value.toString())
    val games = gamesListManager.gamesListResponse.value
    games
//    LazyColumn{
//        items(
//            games
//        ){game ->
//            GameCard(app = game)
//        }
//    }
}

@Composable
fun GameCard(app: GamesList){
    Column {
        Row {
            Text(text = "Game")
//            Text(text = app.appid.toString())
//            Text(text = app.name)
        }
    }
}