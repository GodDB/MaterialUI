package com.example.conductorui.TopChart.TopPaid

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluelinelabs.conductor.Controller
import com.example.conductorui.R
import com.example.conductorui.data.BookVO

class TopPaidController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        val view = inflater.inflate(R.layout.controller_toppaid, container, false)

        view.findViewById<RecyclerView>(R.id.recycler).apply {
            this.layoutManager = LinearLayoutManager(activity)
            this.scrollToPosition(0)
            this.adapter = TopPaidRecycleAdapter(initData())
            this.itemAnimator = DefaultItemAnimator()
        }

        Log.d("godgod", "탑차트 - topPicks 컨트롤러 라우터 :  ${router}  백스택   : ${router.backstack}    ")
        return view
    }

    fun initData(): MutableList<BookVO> {
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
}