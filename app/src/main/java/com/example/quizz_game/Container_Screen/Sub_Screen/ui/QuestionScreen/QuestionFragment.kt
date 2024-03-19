package com.example.quizz_game.Container_Screen.Sub_Screen.ui.QuestionScreen

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
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
        viewModel.fetchData()
        viewModel.data.observe(requireActivity(), Observer { data ->
            with(questionFmBinding) {
                answer1.text = data.answer1
                answer2.text = data.answer2
                answer3.text = data.answer3
                answer4.text = data.answer4
                tvQuestion.text = data.question
            }
        })

        Log.d("---","${viewModel.fetchData()}")

        questionFmBinding.answer1.setOnClickListener(){
            countdownTimer()
        }
        questionFmBinding.answer2.setOnClickListener(){
            countdownTimer()
        }
        questionFmBinding.answer3.setOnClickListener(){
            countdownTimer()
        }
        questionFmBinding.answer4.setOnClickListener(){
            countdownTimer()
        }
        questionFmBinding.menu.setOnClickListener(){v ->
            showPopupMenu(v)
        }
    }

    private fun countdownTimer() {
        val animator = ValueAnimator.ofFloat(100f, 0f)
        animator.duration = 7000 // Đặt thời gian kéo từ 100 về 0 là 1 giây (1000 milliseconds)

        animator.addUpdateListener { valueAnimator ->
            val progress = valueAnimator.animatedValue as Float
            questionFmBinding.progressHorizontal.progress = progress.toInt()
        }
        animator.start() // Bắt đầu animation
    }

    private fun showPopupMenu(v: View) {
        val popupMenu = PopupMenu(requireContext(), v)
        popupMenu.inflate(R.menu.popup_menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_finish -> {
                    NavHostFragment.findNavController(this@QuestionFragment).navigate(R.id.action_questionFragment_to_resultFragment)
                    true
                }
                R.id.action_delete -> {
                    // Xử lý khi mục "Delete" được chọn
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

}