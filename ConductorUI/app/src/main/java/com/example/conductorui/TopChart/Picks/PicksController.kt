package com.example.conductorui.TopChart.Picks

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluelinelabs.conductor.Controller
import com.example.conductorui.R
import com.example.conductorui.data.TourVO

class PicksController : Controller(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_picks, container, false)

        view.findViewById<RecyclerView>(R.id.picks_recycle).apply {
            this.layoutManager = LinearLayoutManager(activity)
            this.scrollToPosition(0)
            this.adapter = PicksRecycleAdapter(initData())
            this.itemAnimator = DefaultItemAnimator()
        }

        Log.d("godgod", "탑차트 - picks 컨트롤러 라우터 :  ${router}  백스택   : ${router.backstack}    ")

        return view
    }

    fun initData() : MutableList<MutableList<TourVO>>{

        return mutableListOf<MutableList<TourVO>>().apply {
            for(i in 0 until 100){
                val temp = mutableListOf<TourVO>()
                temp.add(TourVO(R.drawable.sunset, "Best New City Guides", "Kinfolk", "Mark D. Sikes"))
                temp.add(TourVO(R.drawable.sunset, "Best New City Guides", "Kinfolk", "Mark D. Sikes"))
                temp.add(TourVO(R.drawable.sunset, "Best New City Guides", "Kinfolk", "Mark D. Sikes"))
                add(temp)
            }
        }
    }

}