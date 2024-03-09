package com.example.quizz_game.Container_Screen.Sub_Screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.quizz_game.R
import com.example.quizz_game.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment() {

    private lateinit var questionFmBinding: FragmentQuestionBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        questionFmBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_question, container, false)
        return questionFmBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(questionFmBinding){
            answer1.setBackgroundColor(resources.getColor(R.color.grey))
            answer2.setBackgroundColor(resources.getColor(R.color.grey))
            answer3.setBackgroundColor(resources.getColor(R.color.grey))
            answer4.setBackgroundColor(resources.getColor(R.color.grey))
        }

        questionFmBinding.answer1.setOnClickListener(){
            changeBackgroundColor(questionFmBinding.answer1)
        }
        questionFmBinding.answer2.setOnClickListener(){
            changeBackgroundColor(questionFmBinding.answer2)
        }
        questionFmBinding.answer3.setOnClickListener(){
            changeBackgroundColor(questionFmBinding.answer3)
        }
        questionFmBinding.answer4.setOnClickListener(){
            changeBackgroundColor(questionFmBinding.answer4)
        }
    }
    private fun changeBackgroundColor(clickedButton: AppCompatButton) {
        val buttonList: List<AppCompatButton> = listOf(
            questionFmBinding.answer1,
            questionFmBinding.answer2,
            questionFmBinding.answer3,
            questionFmBinding.answer4
        )
        buttonList.forEach { button ->
            button.setBackgroundColor(resources.getColor(R.color.grey))
        }
        clickedButton.setBackgroundColor(resources.getColor(R.color.gold))
    }
}