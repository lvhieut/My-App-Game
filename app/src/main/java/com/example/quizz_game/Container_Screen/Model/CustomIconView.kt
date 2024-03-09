package com.example.quizz_game.Container_Screen.Model

data class CustomIconView(
    val drawableResId: Int,
    val drawableResId1: Int?,
    val drawableResI2: Int?,
    val borderColor: Int?,
    val bgColor: Int?,
    val shouldShowDivider: Boolean
) {
    constructor(drawableResId: Int, shouldShowDivider: Boolean) : this(drawableResId,null,null,null,null,  shouldShowDivider)
}