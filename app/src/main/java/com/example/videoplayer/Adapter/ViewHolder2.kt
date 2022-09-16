package com.example.videoplayer.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplayer.R

class ViewHolder2 (inflater: LayoutInflater,parent:ViewGroup) :RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list2,parent,false))
{
    val img2 : ImageView = itemView.findViewById(R.id.img2)

    fun bind(data: MovieData2){
        img2.setImageResource(data.img2)
    }
}