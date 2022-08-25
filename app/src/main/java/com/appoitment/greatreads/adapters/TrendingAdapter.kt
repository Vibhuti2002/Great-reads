package com.appoitment.greatreads.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.appoitment.greatreads.R
import com.appoitment.greatreads.dataclasses.HomeDataClass
import com.appoitment.greatreads.fragments.Home

class TrendingAdapter(private var mListener: Home, private val data: List<HomeDataClass>):RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    private val item : MutableList<CardView>
        get() {
            TODO()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_trending, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.image.setImageResource(data[position].image)
        item.add(holder.card)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder
    internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.cardrecycler)
        val title: TextView = itemView.findViewById(R.id.headingHorizontal)
        val card: CardView = itemView.findViewById(R.id.card)

    }
}