package com.example.conductorui.Main.Main2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluelinelabs.conductor.Controller
import com.example.conductorui.R
import com.example.conductorui.data.BookVO

class Main2Controller() : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_main2, container, false)

        view.findViewById<RecyclerView>(R.id.main2_recycle).apply {
            this.layoutManager = GridLayoutManager(activity, 2)
            this.scrollToPosition(0)
            this.adapter = Main2RecycleAdapter(initData1())
            this.itemAnimator = DefaultItemAnimator()
        }

        return view

        Log.d("godgod", "메인 컨트롤러2 라우터 :  ${router}  백스택   : ${router.backstack}    ")
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

}