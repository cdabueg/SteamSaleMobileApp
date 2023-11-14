package com.example.steamsaleapp.API
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface API_Retrofit_Interface {
    @GET("ISteamApps/GetAppList/v2?format=json")
    fun getSteamApplist(): Call<SteamApplistResponse>
}


object RetrofitClient {
    private const val BASE_URL = "http://api.steampowered.com/"

    val instance: API_Retrofit_Interface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(API_Retrofit_Interface::class.java)
    }
}

