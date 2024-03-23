package com.example.quizz_game.Container_Screen.Sub_Screen.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.quizz_game.R
import com.example.quizz_game.databinding.FragmentIntroScreenBinding


class Intro_Screen : Fragment() {

    private lateinit var introScreen: FragmentIntroScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        introScreen = DataBindingUtil.inflate(inflater,R.layout.fragment_intro__screen, container, false)
        return introScreen.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()

        introScreen.btnNext.setOnClickListener {
            NavHostFragment.findNavController(this@Intro_Screen).navigate(R.id.action_intro_Screen_to_game_Play_Screen)

        }

    }

    override fun onPause() {
        super.onPause()
        Log.d("hieulv","Pause FmA")
    }

    override fun onStop() {

        super.onStop()
        Log.d("hieulv","onStop FmA")
    }

    override fun onDestroyView() {
        Log.d("hieulv","onDestroyView FmA")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("hieulv","onDestroy FmA")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("hieulv","onDetach FmA")
        super.onDetach()
    }

}