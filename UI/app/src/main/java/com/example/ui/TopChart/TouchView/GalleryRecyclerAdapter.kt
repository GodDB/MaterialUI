package com.example.ui.TopChart.TouchView

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R

class GalleryRecyclerAdapter(val dataList : MutableList<Uri>) : RecyclerView.Adapter<GalleryRecyclerAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_gallery_image_activity_items, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.iv.setImageURI(dataList[position])
    }


    inner class VH(itemView : View): RecyclerView.ViewHolder(itemView) {
        val iv = itemView.findViewById<ImageView>(R.id.galleryiv)

        init {
            iv.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("iv",iv.drawable.toString())
                TouchViewFragment.arguments = bundle
            }
        }
    }
}