package com.example.ui.TopChart.Picks

import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.transition.Transition
import android.transition.TransitionManager
import android.util.Log
import com.example.ui.R
import com.example.ui.data.TourVO


class PicksRecycleAdapter(val dataList : MutableList<MutableList<TourVO>>) : RecyclerView.Adapter<PicksRecycleAdapter.MyRecycleVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleVH{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_picks_items, parent,false)
        return MyRecycleVH(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyRecycleVH, position: Int) {
        holder.iv1.setImageResource(dataList[position][0].iv)
        holder.title1.text = dataList[position][0].title
        holder.author1.text = dataList[position][0].author
        holder.subtitle1.text = dataList[position][0].subTitle

        holder.iv2.setImageResource(dataList[position][1].iv)
        holder.title2.text = dataList[position][1].title
        holder.author2.text = dataList[position][1].author
        holder.subtitle2.text = dataList[position][1].subTitle

        holder.iv3.setImageResource(dataList[position][2].iv)
        holder.title3.text = dataList[position][2].title
        holder.author3.text = dataList[position][2].author
        holder.subtitle3.text = dataList[position][2].subTitle
    }


    inner class MyRecycleVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        var iv1 = itemView.findViewById<ImageView>(R.id.picks_iv1)
        var title1 = itemView.findViewById<TextView>(R.id.picks_title1)
        var author1 = itemView.findViewById<TextView>(R.id.picks_author1)
        var subtitle1 = itemView.findViewById<TextView>(R.id.picks_subtitle1)
        var iv2 = itemView.findViewById<ImageView>(R.id.picks_iv2)
        var title2 = itemView.findViewById<TextView>(R.id.picks_title2)
        var author2 = itemView.findViewById<TextView>(R.id.picks_author2)
        var subtitle2 = itemView.findViewById<TextView>(R.id.picks_subtitle2)
        var iv3 = itemView.findViewById<ImageView>(R.id.picks_iv3)
        var title3 = itemView.findViewById<TextView>(R.id.picks_title3)
        var author3 = itemView.findViewById<TextView>(R.id.picks_author3)
        var subtitle3 = itemView.findViewById<TextView>(R.id.picks_subtitle3)
        var count = 0

        init {
            val transition = Slide(Gravity.TOP).apply { setDuration(600); addTarget(R.id.picks_group) } as Transition
            TransitionManager.beginDelayedTransition(itemView as ViewGroup, transition)

            itemView.setOnClickListener {
                when(count){
                    0 -> {
                        it.findViewById<ConstraintLayout>(R.id.picks_group).visibility = ViewGroup.VISIBLE
                        it.findViewById<TextView>(R.id.picks_show).text = "HIDE"
                        count++
                    }
                    1 -> {
                        it.findViewById<ConstraintLayout>(R.id.picks_group).visibility = ViewGroup.GONE
                        it.findViewById<TextView>(R.id.picks_show).text = "SHOW ALL"
                        count--
                    }

                }

            }
        }
    }

}