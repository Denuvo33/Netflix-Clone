package com.example.videoplayer.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val data : ArrayList<MovieData>): RecyclerView.Adapter<ViewHolder>() {

    var onItemClick : ((MovieData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        val movieData = data[position]
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(movieData)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}