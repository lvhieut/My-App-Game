package com.example.quizz_game.Container_Screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.quizz_game.R
import com.example.quizz_game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var homeBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

    }
}