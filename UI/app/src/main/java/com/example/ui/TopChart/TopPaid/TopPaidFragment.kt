package com.example.ui.TopChart.TopPaid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R
import com.example.ui.data.BookVO

class TopPaidFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_toppaid, container, false)
        val mLayoutManager : LinearLayoutManager = LinearLayoutManager(activity)

        var dataList = initData()
        val mAdapter =
            TopPaidRecycleAdapter(dataList)

        view.findViewById<RecyclerView>(R.id.recycler).apply {
            this.layoutManager = mLayoutManager
            this.scrollToPosition(0)
            this.adapter = mAdapter
            this.itemAnimator = DefaultItemAnimator()
        }
        return view
    }


    fun initData() : MutableList<BookVO>{
        val dataList = mutableListOf<BookVO>()
        for(i in 0..100) dataList.add(BookVO(R.drawable.book_iv, "1. Color at Home : A Young House Love Coloring Book", "Sherry Petersilk", 5.0, 12.5))

        return dataList
    }
}