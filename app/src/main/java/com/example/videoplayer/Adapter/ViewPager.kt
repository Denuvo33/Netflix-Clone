package com.example.videoplayer.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplayer.R

class ViewPager (private var image : List<Int>,private var title:List<String>,private var desc:List<String>):RecyclerView.Adapter<ViewPager.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemview : View): RecyclerView.ViewHolder(itemview) {
        val title : TextView = itemView.findViewById(R.id.txt_titleVP)
        val img : ImageView = itemView.findViewById(R.id.img_vp)
        val desc : TextView = itemView.findViewById(R.id.txt_descVP)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.itempage,parent,false))
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.title.text = title[position]
        holder.img.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }


}