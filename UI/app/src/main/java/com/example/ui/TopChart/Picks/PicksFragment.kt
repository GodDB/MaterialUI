package com.example.ui.TopChart.Picks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.Main.Main2.Main2RecycleAdapter
import com.example.ui.R
import com.example.ui.data.BookVO
import com.example.ui.data.TourVO


class PicksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_picks, container, false)

        val layoutManager = LinearLayoutManager(activity)
        val picksRecycleAdapter = PicksRecycleAdapter(initData())

        view.findViewById<RecyclerView>(R.id.picks_recycle).apply {
            this.layoutManager = layoutManager
            this.scrollToPosition(0)
            this.adapter = picksRecycleAdapter
            this.itemAnimator = DefaultItemAnimator()
        }

        return view
    }

    fun initData() : MutableList<MutableList<TourVO>>{
        val dataList = mutableListOf<MutableList<TourVO>>()

        for(i in 0 until 100){
            val temp = mutableListOf<TourVO>()
            temp.add(TourVO(R.drawable.sunset, "Best New City Guides", "Kinfolk", "Mark D. Sikes"))
            temp.add(TourVO(R.drawable.sunset, "Best New City Guides", "Kinfolk", "Mark D. Sikes"))
            temp.add(TourVO(R.drawable.sunset, "Best New City Guides", "Kinfolk", "Mark D. Sikes"))
            dataList.add(temp)
        }
        return dataList
    }


}


