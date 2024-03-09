package com.example.quizz_game.Container_Screen.Sub_Screen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.quizz_game.R
import com.example.quizz_game.databinding.FragmentGamePlayScreenBinding


class GamePlayFragment : Fragment() {

    private lateinit var gamePlayScrBinding: FragmentGamePlayScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        gamePlayScrBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_game__play__screen, container, false)
        return gamePlayScrBinding.root
    }

    override fun onResume() {
        super.onResume()

        gamePlayScrBinding.btnRight.setOnClickListener {
            NavHostFragment.findNavController(this@GamePlayFragment).navigate(R.id.action_game_Play_Screen_to_roadmapFragment)
        }

        gamePlayScrBinding.multiplayer.setOnClickListener(){
            NavHostFragment.findNavController(this@GamePlayFragment).navigate(R.id.action_game_Play_Screen_to_questionFragment)
        }


    }


}