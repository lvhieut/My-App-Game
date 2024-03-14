package com.example.quizz_game.Container_Screen.api

import com.example.quizz_game.Container_Screen.Model.QuestionListResponseItemX
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("/question/listquiz/{id}")
     fun getQuestion(@Path("id") id: Int): Call<QuestionListResponseItemX>


}