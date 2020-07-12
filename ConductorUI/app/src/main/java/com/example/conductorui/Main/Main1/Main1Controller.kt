package com.example.conductorui.Main.Main1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.example.conductorui.R
import com.example.conductorui.TopChart.TopChartController
import com.example.conductorui.data.BookVO
import com.example.ui.Main.Main1.AuthorRecycleAdapter
import com.example.ui.Main.Main1.CategoryRecycleAdapter
import com.example.ui.Main.Main1.ChartRecycleAdapter

class Main1Controller : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        val view = inflater.inflate(R.layout.controller_main1, container, false)

        view.findViewById<RecyclerView>(R.id.main1Recycle).apply {
            this.layoutManager = LinearLayoutManager(activity).apply {
                this.orientation = LinearLayoutManager.HORIZONTAL
            }
            this.scrollToPosition(0)
            this.adapter = CategoryRecycleAdapter(initdata())
            this.itemAnimator = DefaultItemAnimator()
        }

        view.findViewById<RecyclerView>(R.id.main1_chart_recycler).apply {
            this.layoutManager = LinearLayoutManager(activity).apply {
                this.orientation = LinearLayoutManager.HORIZONTAL
            }
            this.scrollToPosition(0)
            this.adapter = ChartRecycleAdapter(initData1())
            this.itemAnimator = DefaultItemAnimator()
        }

        view.findViewById<RecyclerView>(R.id.main1_author_recycler).apply {
            this.layoutManager = LinearLayoutManager(activity).apply {
                this.orientation = LinearLayoutManager.HORIZONTAL
            }
            this.scrollToPosition(0)
            this.adapter = AuthorRecycleAdapter(initData2())
            this.itemAnimator = DefaultItemAnimator()
        }

        view.findViewById<TextView>(R.id.main1_chart_more).setOnClickListener {
            parentController!!.router.pushController(
                RouterTransaction.with(TopChartController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
            )
        }
        return view

        Log.d("godgod", "메인 컨트롤러1 라우터 :  ${router}  백스택   : ${router.backstack}    ")
    }


    fun initdata(): MutableList<String> {
        return mutableListOf(
            "FOR YOU",
            "CATEGORIES",
            "GENRES",
            "BESTSELLERS",
            "PICKS",
            "SUGGESTIONS",
            "WISH",
            "DETAILS",
            "REVIEWS",
            "RELATED"
        )
    }

    fun initData1(): MutableList<BookVO> {
        return mutableListOf<BookVO>().apply {
            for (i in 0..100)
                add(
                    BookVO(
                        R.drawable.book_iv,
                        "1. Color at Home : A Young House Love Coloring Book",
                        "Sherry Petersilk",
                        5.0,
                        12.5
                    )
                )
        }
    }

    fun initData2(): MutableList<BookVO> {
        return mutableListOf<BookVO>().apply {
            for (i in 0..100) add(
                BookVO(
                    R.drawable.author,
                    "1. Color at Home : A Young House Love Coloring Book",
                    "Sherry Petersilk",
                    5.0,
                    12.5
                )
            )
        }
    }
}
