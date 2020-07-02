package com.example.ui.Main.Main2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R
import com.example.ui.data.BookVO

class Main2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main2, container, false)

        val layoutManager = GridLayoutManager(activity, 2)
        val main2RecycleAdapter = Main2RecycleAdapter(initData1())

        view.findViewById<RecyclerView>(R.id.main2_recycle).apply {
            this.layoutManager = layoutManager
            this.scrollToPosition(0)
            this.adapter = main2RecycleAdapter
            this.itemAnimator = DefaultItemAnimator()
        }


        return view
    }

    fun initData1() : MutableList<BookVO>{
        val dataList = mutableListOf<BookVO>()
        for(i in 0..100) dataList.add(BookVO(R.drawable.book_iv, "1. Color at Home : A Young House Love Coloring Book", "Sherry Petersilk", 5.0, 12.5))

        return dataList
    }

}