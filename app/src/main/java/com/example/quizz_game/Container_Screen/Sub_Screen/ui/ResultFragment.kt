package com.example.quizz_game.Container_Screen.Sub_Screen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.quizz_game.R
import com.example.quizz_game.databinding.FragmentResultBinding
import com.example.quizz_game.databinding.FragmentRoadmapBinding


class ResultFragment : Fragment() {
    private lateinit var resultScrBinding: FragmentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resultScrBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_result, container, false)
        // Inflate the layout for this fragment
        return resultScrBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}