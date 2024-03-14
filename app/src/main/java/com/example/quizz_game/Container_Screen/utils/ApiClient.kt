package com.example.quizz_game.Container_Screen.utils

import com.example.quizz_game.Container_Screen.api.ApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL = "https://65f2ee61105614e6549f4f05.mockapi.io"
    const val NETWORK_TIMEOUT = 60L



    fun create(): ApiServices {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiServices::class.java)
    }


}