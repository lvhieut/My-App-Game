package com.example.quizz_game.Container_Screen.Sub_Screen.Adapter

import OnItemClick
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz_game.Container_Screen.Model.StateButton
import com.example.quizz_game.R


class QuestionAnswer(listButton: List<StateButton>, private val context: Context) :
    RecyclerView.Adapter<QuestionAnswer.ViewHolder>() {
    // Dữ liệu để hiển thị
    private val listButton: List<StateButton>
    private var listener: OnItemClick? = null

    fun setOnItemClick(listener : OnItemClick){
        this.listener = listener
    }

    // Constructor để truyền vào dữ liệu
    init {
        this.listButton = listButton
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Tạo view cho mỗi item
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_button,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listButton.size
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Gán dữ liệu cho các thành phần trong item
        val buttonObj: StateButton = listButton[position]
        holder.title.text = buttonObj.title
        holder.itemView.setOnClickListener(){
            listener?.onItemClick(position)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.btnTitle)
    }
}