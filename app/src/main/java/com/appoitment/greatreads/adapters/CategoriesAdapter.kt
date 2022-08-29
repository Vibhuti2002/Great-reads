package com.appoitment.greatreads.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.appoitment.greatreads.R
import com.appoitment.greatreads.data.CategoriesData
import com.appoitment.greatreads.fragments.CategoriesFragment
import com.appoitment.greatreads.fragments.Home
import com.bumptech.glide.Glide
import com.google.common.collect.Iterators.size
import java.nio.file.Files.size

class CategoriesAdapter(private var mListener: CategoriesFragment, private val categoriesData : List<CategoriesData>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.ivCategory)
        val name: TextView = itemView.findViewById(R.id.tvCategories)
        val card: CardView = itemView.findViewById(R.id.card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
        return CategoriesAdapter.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = categoriesData[position]
        holder.apply {
            name.text = currentData.name
        }
        Glide.with(holder.itemView.context).load(currentData.image).into(holder.image);
    }

    override fun getItemCount(): Int {
        return categoriesData.size
    }
}