package com.example.quizz_game.Container_Screen.Sub_Screen.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz_game.Container_Screen.Custom_View.Hexagon_shape.HexagonView
import com.example.quizz_game.Container_Screen.Model.CustomIconView
import com.example.quizz_game.R


class RoadmapAdapter(dataList: List<CustomIconView>,private val context: Context) :
    RecyclerView.Adapter<RoadmapAdapter.ViewHolder>() {
    // Dữ liệu để hiển thị
    private val dataList: List<CustomIconView>

    // Constructor để truyền vào dữ liệu
    init {
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Tạo view cho mỗi item
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Gán dữ liệu cho các thành phần trong item
        val data: CustomIconView = dataList[position]
        val drawable = ContextCompat.getDrawable(holder.itemView.context, data.drawableResId)


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        private val context: Context = itemView.context
//        private val myLinearLayout: LinearLayout = itemView.findViewById(R.id.linearLayoutRoadmap)
//        private val dividerView: View = itemView.findViewById(R.id.divider)
//        private val dividerView1: View = itemView.findViewById(R.id.divider2)
//        private val dividerView2: View = itemView.findViewById(R.id.divider3)

//        val hexagon = myLinearLayout.findViewById<HexagonView>(R.id.customView)
//        val hexagonView: HexagonView = itemView.findViewById(R.id.customView)
//        val hexagonView1: HexagonView = itemView.findViewById(R.id.customView1)
//        val hexagonView2: HexagonView = itemView.findViewById(R.id.customView2)
//
//        val hexegonViewId: Int = hexagon.id

//        fun bindData(drawable: Drawable) {
//            val hexagon =
//            hexagonView.updateView(drawable)
//            hexagonView1.updateView(drawable)
//            hexagonView2.updateView(drawable)
//        }

//        fun hideDivider() {
//            dividerView.visibility = View.GONE
//        }
//
//        fun showDivider() {
//            dividerView1.visibility = View.GONE
//        }
    }
}