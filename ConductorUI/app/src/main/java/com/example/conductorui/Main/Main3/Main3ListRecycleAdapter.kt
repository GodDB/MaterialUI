package com.example.conductorui.Main.Main3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.conductorui.R
import com.example.conductorui.data.ListVO


class Main3ListRecycleAdapter(val dataList: MutableList<ListVO>) : RecyclerView.Adapter<Main3ListRecycleAdapter.MyRecycleVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.controller_main3_list_items, parent, false)
        return MyRecycleVH(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onBindViewHolder(holder: MyRecycleVH, position: Int) {
        holder.iv.setImageResource(dataList[position].iv)
        holder.subTitle.text = dataList[position].subTitle
        holder.title.text = dataList[position].title
    }

    inner class MyRecycleVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv = itemView.findViewById<ImageView>(R.id.main3_list_iv)
        var title = itemView.findViewById<TextView>(R.id.main3_list_title)
        var subTitle = itemView.findViewById<TextView>(R.id.main3_list_subTitle)

    }
}
