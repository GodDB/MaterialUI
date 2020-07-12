package com.example.ui.Main.Main1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.conductorui.R
import com.example.conductorui.data.BookVO


class AuthorRecycleAdapter(val dataList: MutableList<BookVO>) : RecyclerView.Adapter<AuthorRecycleAdapter.MyRecycleVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.controller_main1_author_items, parent, false)
        return MyRecycleVH(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onBindViewHolder(holder: MyRecycleVH, position: Int) {
        holder.iv.setImageResource(dataList[position].image)
        holder.author.text = dataList[position].authorName
    }

    inner class MyRecycleVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv = itemView.findViewById<ImageView>(R.id.main1_author_iv)
        var author = itemView.findViewById<TextView>(R.id.main1_author_author)
    }
}
