package com.example.quizz_game.Container_Screen.Sub_Screen.ui.QuestionScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizz_game.Container_Screen.Model.QuestionListResponseItemX
import com.example.quizz_game.Container_Screen.utils.ApiClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class ViewModelQuestionScr : ViewModel() {


    private val _data = MutableLiveData<QuestionListResponseItemX>() // Dữ liệu trả về từ API
    val data: LiveData<QuestionListResponseItemX> = _data

    fun fetchData() {
        val apiService = ApiClient.create()
        val call = apiService.getQuestion(1)

        call.enqueue(object : Callback<QuestionListResponseItemX> {
            override fun onResponse(call: Call<QuestionListResponseItemX>, response: Response<QuestionListResponseItemX>) {
                if (response.isSuccessful) {
                    _data.value = response.body() //question
                    Log.d("hieulv","${response.body()}")
                } else {
                    // Xử lý lỗi nếu cần thiết
                    val errorCode = response.code()
                }
            }

            override fun onFailure(call: Call<QuestionListResponseItemX>, t: Throwable) {
                // Xử lý lỗi kết nối nếu cần thiết
            }
        })

    }

}