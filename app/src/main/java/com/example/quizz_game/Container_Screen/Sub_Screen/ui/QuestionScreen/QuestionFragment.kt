package com.example.quizz_game.Container_Screen.Sub_Screen.ui.QuestionScreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quizz_game.R
import com.example.quizz_game.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment() {

    private lateinit var questionFmBinding: FragmentQuestionBinding
    private lateinit var viewModel: ViewModelQuestionScr



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

        viewModel = ViewModelProvider(this).get(ViewModelQuestionScr::class.java)


        viewModel.data.observe(requireActivity(), Observer { data ->
            with(questionFmBinding) {
                answer1.text = data.answer1
                answer2.text = data.answer2
                answer3.text = data.answer3
                answer4.text = data.answer4
                tvQuestion.text = data.question
            }
        })

        viewModel.fetchData()
        Log.d("---","${viewModel.fetchData()}")

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