package com.example.conductorui.Main.Main2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.conductorui.R
import com.example.conductorui.data.BookVO


class Main2RecycleAdapter(val dataList: MutableList<BookVO>) : RecyclerView.Adapter<Main2RecycleAdapter.MyRecycleVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.controller_main2_items, parent, false)
        return MyRecycleVH(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onBindViewHolder(holder: MyRecycleVH, position: Int) {
        holder.iv.setImageResource(dataList[position].image)
        holder.author.text = dataList[position].authorName
        holder.title.text = dataList[position].title
    }

    inner class MyRecycleVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv = itemView.findViewById<ImageView>(R.id.main2_iv)
        var title = itemView.findViewById<TextView>(R.id.main2_title)
        var author = itemView.findViewById<TextView>(R.id.main2_author)

    }
}
