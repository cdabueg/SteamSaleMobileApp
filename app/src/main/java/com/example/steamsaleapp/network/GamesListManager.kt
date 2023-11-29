package com.example.steamsaleapp.network

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.steamsaleapp.model.GamesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GamesListManager {
    private var _gamesListResponse = mutableStateOf<GamesList>(GamesList())

    // state allow us to make data available to other class external to this one
    val gamesListResponse: MutableState<GamesList>
        @Composable get() = remember{
            _gamesListResponse
        }

    init{
        // Call the get method
        getGamesList()
    }
    private fun getGamesList(){
        val service = Api.retrofitService.getSteamGames()

        service.enqueue(object : Callback<GamesList> {
            override fun onResponse(
                call: Call<GamesList>,
                response: Response<GamesList>
            ) {
                _gamesListResponse.value = response.body() ?: GamesList()
            }

            override fun onFailure(call: Call<GamesList>, t: Throwable) {
                Log.d("error", "${t.message}")
            }

        })
    }
}