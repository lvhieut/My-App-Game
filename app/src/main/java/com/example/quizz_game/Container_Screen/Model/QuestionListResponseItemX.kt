package com.example.quizz_game.Container_Screen.Model

data class QuestionListResponseItemX(
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val id: String,
    val imageCode: String,
    val question: String,
    val trueAnswer: String
)