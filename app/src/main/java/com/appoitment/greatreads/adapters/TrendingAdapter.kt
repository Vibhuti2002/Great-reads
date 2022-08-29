package com.appoitment.greatreads.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.appoitment.greatreads.R
import com.appoitment.greatreads.data.TrendingData
import com.appoitment.greatreads.fragments.Home
import com.bumptech.glide.Glide

class TrendingAdapter(private var mListener: Home, private val trendingData: List<TrendingData>):RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    private val item : MutableList<CardView>
        get() {
            TODO()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_trending, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = trendingData[position]
        holder.apply {
            name.text = currentData.name
        }
        Glide.with(holder.itemView.context).load(currentData.image).into(holder.image);
    }

    override fun getItemCount(): Int {
        return trendingData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.ivTrending)
        val name: TextView = itemView.findViewById(R.id.tvBookName)
        val card: CardView = itemView.findViewById(R.id.card)
    }
}