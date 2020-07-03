package com.example.ui.TopChart.TouchView

import android.content.ContentResolver
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.Main.Main2.Main2RecycleAdapter
import com.example.ui.R
import java.text.SimpleDateFormat
import java.util.*

class GalleryImageAcitivity : AppCompatActivity() {
    val dataList : MutableList<Uri> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_image_acitivity)

        val cr : ContentResolver = contentResolver
        val cursor : Cursor? = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            sortOrder)
        cursor?.use {
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val contentUri = Uri.withAppendedPath(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id.toString()
                )
                dataList.add(contentUri)
            }
        }


        val layoutManager = GridLayoutManager(this, 4)
        val galleryRecyclerAdapter = GalleryRecyclerAdapter(dataList)

        findViewById<RecyclerView>(R.id.galleryRecycle).apply {
            this.layoutManager = layoutManager
            this.scrollToPosition(0)
            this.adapter = galleryRecyclerAdapter
            this.itemAnimator = DefaultItemAnimator()
        }

    }

    val projection = arrayOf(
        MediaStore.Images.Media._ID,
        MediaStore.Images.Media.DISPLAY_NAME,
        MediaStore.Images.Media.DATE_TAKEN
    )
    val selection = "${MediaStore.Images.Media.DATE_TAKEN} >= ?"
    val selectionArgs = arrayOf(
        dateToTimestamp(day = 1, month = 1, year = 2020).toString()
    )
    val sortOrder = "${MediaStore.Images.Media.DATE_TAKEN} DESC"


    private fun dateToTimestamp(day: Int, month: Int, year: Int): Long =
        SimpleDateFormat("dd.MM.yyyy").let { formatter ->
            formatter.parse("$day.$month.$year")?.time ?: 0
        }
}