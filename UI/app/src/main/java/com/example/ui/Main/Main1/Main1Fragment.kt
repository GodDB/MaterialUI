package com.example.ui.Main.Main1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R
import com.example.ui.TopChart.TopChartActivity
import com.example.ui.data.BookVO

class Main1Fragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main1, container, false)
        val layoutManager : LinearLayoutManager = LinearLayoutManager(activity).apply { this.orientation = LinearLayoutManager.HORIZONTAL }
        val layoutManager1 : LinearLayoutManager = LinearLayoutManager(activity).apply { this.orientation = LinearLayoutManager.HORIZONTAL }
        val layoutManager2 : LinearLayoutManager = LinearLayoutManager(activity).apply { this.orientation = LinearLayoutManager.HORIZONTAL }
        val categoryRecycleAdapter =
            CategoryRecycleAdapter(initdata())
        val chartRecycleAdapter =
            ChartRecycleAdapter(initData1())
        val authorRecycleAdapter =
            AuthorRecycleAdapter(initData2())

        view.findViewById<RecyclerView>(R.id.main1Recycle).apply {
            this.layoutManager = layoutManager
            this.scrollToPosition(0)
            this.adapter = categoryRecycleAdapter
            this.itemAnimator = DefaultItemAnimator()
        }

        view.findViewById<RecyclerView>(R.id.main1_chart_recycler).apply {
            this.layoutManager = layoutManager1
            this.scrollToPosition(0)
            this.adapter = chartRecycleAdapter
            this.itemAnimator = DefaultItemAnimator()
        }

        view.findViewById<RecyclerView>(R.id.main1_author_recycler).apply {
            this.layoutManager = layoutManager2
            this.scrollToPosition(0)
            this.adapter = authorRecycleAdapter
            this.itemAnimator = DefaultItemAnimator()
        }

        view.findViewById<TextView>(R.id.main1_chart_more).setOnClickListener {
            val intent = Intent(activity, TopChartActivity::class.java)
            startActivity(intent)
        }

        return view
    }


    fun initdata() : MutableList<String>{
        val dataList : MutableList<String> = mutableListOf()
        dataList.add("FOR YOU")
        dataList.add("CATEGORIES")
        dataList.add("GENRES")
        dataList.add("BESTSELLERS")
        dataList.add("PICKS")
        dataList.add("SUGGESTIONS")
        dataList.add("WISH")
        dataList.add("DETAILS")
        dataList.add("REVIEWS")
        dataList.add("RELATED")

        return dataList
    }

    fun initData1() : MutableList<BookVO>{
        val dataList = mutableListOf<BookVO>()
        for(i in 0..100) dataList.add(BookVO(R.drawable.book_iv, "1. Color at Home : A Young House Love Coloring Book", "Sherry Petersilk", 5.0, 12.5))

        return dataList
    }

    fun initData2() : MutableList<BookVO>{
        val dataList = mutableListOf<BookVO>()
        for(i in 0..100) dataList.add(BookVO(R.drawable.author, "1. Color at Home : A Young House Love Coloring Book", "Sherry Petersilk", 5.0, 12.5))

        return dataList
    }

}