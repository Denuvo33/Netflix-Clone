package com.example.videoplayer.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplayer.R

class ViewHolder(inflater: LayoutInflater,parent:ViewGroup):RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list,parent,false)) {
    var img : ImageView = itemView.findViewById(R.id.img)

    fun bind(data: MovieData){
        img.setImageResource(data.movieImg)
    }

}