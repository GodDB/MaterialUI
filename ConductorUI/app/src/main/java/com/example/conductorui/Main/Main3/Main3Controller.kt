package com.example.conductorui.Main.Main3

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluelinelabs.conductor.Controller
import com.example.conductorui.Main.Main2.Main2RecycleAdapter
import com.example.conductorui.R
import com.example.conductorui.data.BookVO
import com.example.conductorui.data.ListVO

class Main3Controller() : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_main3, container, false)

        val layoutManager = LinearLayoutManager(activity).apply {
            this.orientation = LinearLayoutManager.HORIZONTAL
        }
        val layoutManager1 = LinearLayoutManager(activity)

        val main2RecycleAdapter = Main2RecycleAdapter(initData1()) //main2 리사이클러 어댑터 재사용
        val main3ListRecycleAdapter = Main3ListRecycleAdapter(initList())

        view.findViewById<RecyclerView>(R.id.main3_recycle1).apply {
            this.layoutManager = layoutManager
            this.scrollToPosition(0)
            this.adapter = main2RecycleAdapter
            this.itemAnimator = DefaultItemAnimator()
        }

        view.findViewById<RecyclerView>(R.id.main3_recycle2).apply {
            this.layoutManager = layoutManager1
            this.scrollToPosition(0)
            this.adapter = main3ListRecycleAdapter
            this.itemAnimator = DefaultItemAnimator()
        }

        Log.d("godgod", "메인 컨트롤러3 라우터 :  ${router}  백스택   : ${router.backstack}    ")
        return view
    }


    fun initData1(): MutableList<BookVO> {

        return mutableListOf<BookVO>().apply {
            for (i in 0..100) add(
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

    fun initList(): MutableList<ListVO> {

        return mutableListOf<ListVO>().apply {
            add(ListVO(R.drawable.ic_launcher_main1_foreground, "Now reading", "11 Books"))
            add(
                ListVO(
                    R.drawable.ic_launcher_main2_foreground,
                    "Read later",
                    "23 Magazine , 24 Books"
                )
            )
            add(
                ListVO(
                    R.drawable.ic_launcher_main3_foreground,
                    "Finished",
                    "23 Magazine , 24 Books"
                )
            )
            add(
                ListVO(
                    R.drawable.ic_launcher_list4_foreground,
                    "All my books",
                    "23 Magazine, 11 Books"
                )
            )
        }
    }
}