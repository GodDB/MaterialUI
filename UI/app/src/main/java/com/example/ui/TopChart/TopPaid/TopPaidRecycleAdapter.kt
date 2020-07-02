package com.example.ui.TopChart.TopPaid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R
import com.example.ui.data.BookVO

class TopPaidRecycleAdapter(val dataList: MutableList<BookVO>) : RecyclerView.Adapter<TopPaidRecycleAdapter.MyRecycleVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.toppaiditems, parent, false)
        return MyRecycleVH(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onBindViewHolder(holder: MyRecycleVH, position: Int) {
        holder.iv.setImageResource(dataList[position].image)
        holder.title.text = dataList[position].title
        holder.author.text = dataList[position].authorName
        holder.rating.text = dataList[position].rating.toString()
        holder.price.text = "USD"+dataList[position].price
    }

    inner class MyRecycleVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv : ImageView = itemView.findViewById(R.id.image)
        var title : TextView = itemView.findViewById(R.id.title)
        var author : TextView = itemView.findViewById(R.id.author)
        var rating : TextView = itemView.findViewById(R.id.rating)
        var price : TextView = itemView.findViewById(R.id.price)
    }
}
