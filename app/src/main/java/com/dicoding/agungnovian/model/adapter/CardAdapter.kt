package com.dicoding.agungnovian.model.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.agungnovian.R
import com.dicoding.agungnovian.model.data.CardData
import kotlinx.android.extensions.LayoutContainer
import android.content.Intent
import com.dicoding.agungnovian.view.DetailActivity

class CardAdapter(val context: Context, data: MutableList<CardData>)
    : RecyclerView.Adapter<CardAdapter.ViewHolder>() {
    private val list = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list[position].let { holder.bindItem(it) }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        private val viewItem = itemView.findViewById<RelativeLayout>(R.id.viewItem)
        private val tvwTitle = itemView.findViewById<TextView>(R.id.tvwTitle)
        private val tvwType = itemView.findViewById<TextView>(R.id.tvwType)
        private val tvwSubType = itemView.findViewById<TextView>(R.id.tvwSubType)
        private val tvwDescription = itemView.findViewById<TextView>(R.id.tvwDescription)
        private val imgIcon = itemView.findViewById<ImageView>(R.id.imgIcon)

        fun bindItem(item: CardData) {
            tvwTitle.text = item.name
            tvwDescription.text = item.set

            tvwType.text = item.supertype
            tvwSubType.text = item.subtype

            Glide.with(containerView!!)
                .load(item.imageUrl)
                .into(imgIcon)

            viewItem.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("card", item)
                context.startActivity(intent)
            }
        }
    }
}
