package com.example.quizz_game.Container_Screen.Sub_Screen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizz_game.Container_Screen.Custom_View.Hexagon_shape.HexagonView
import com.example.quizz_game.Container_Screen.Model.CustomIconView
import com.example.quizz_game.Container_Screen.Sub_Screen.Adapter.RoadmapAdapter
import com.example.quizz_game.R
import com.example.quizz_game.databinding.FragmentRoadmapBinding


class RoadmapFragment : Fragment() {

    private lateinit var roadmapScrBinding: FragmentRoadmapBinding
    private lateinit var hexagonView: HexagonView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        roadmapScrBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_roadmap, container, false)
        return roadmapScrBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList = listOf(
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),
            CustomIconView(R.drawable.ic_gift,R.drawable.ic_lock,R.drawable.ic_book_svg,R.color.cyan,R.color.orange,true),

            // ...
        )
        val adapter = RoadmapAdapter(dataList, requireContext())

        with(roadmapScrBinding){
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true).apply { stackFromEnd = true }
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter

            val lastItemPosition = dataList.size - 1

            recyclerView.scrollToPosition(lastItemPosition)

//            recyclerView.scrollBy(0, -100)
        }





    }

}