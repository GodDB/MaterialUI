package com.example.ui.Main.Main1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R

class CategoryRecycleAdapter(val dataList: MutableList<String>) : RecyclerView.Adapter<CategoryRecycleAdapter.MyRecycleVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_main1_items, parent, false)
        return MyRecycleVH(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onBindViewHolder(holder: MyRecycleVH, position: Int) {
        holder.text.text = dataList[position]
    }

    inner class MyRecycleVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var text: TextView = itemView.findViewById(R.id.main1Txt)
    }
}
