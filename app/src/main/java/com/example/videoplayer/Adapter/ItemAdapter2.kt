package com.example.videoplayer.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter2 (private val data2: ArrayList<MovieData2>) : RecyclerView.Adapter<ViewHolder2>() {

    var onItemClick : ((MovieData2) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        val v = LayoutInflater.from(parent.context)
        return ViewHolder2(v,parent)
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        holder.bind(data2[position])
        val movieData2 = data2[position]
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(movieData2)
        }
    }

    override fun getItemCount(): Int {
        return data2.size
    }


}