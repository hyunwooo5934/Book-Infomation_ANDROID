package com.example.book.feature.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.example.book.R
import com.example.book.model.db.bookItem

class MainAdapter(private val context : Context) : RecyclerView.Adapter<MainAdapter.viewHolder>() {

    var datas = mutableListOf<bookItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(datas.get(position))
    }

    fun update(items : List<bookItem>) {
        datas = items.toMutableList()
        notifyDataSetChanged()
    }

    inner class viewHolder(view : View) : RecyclerView.ViewHolder(view){

        private val ImageUrl : ImageView = itemView.findViewById(R.id.imageView)
        private val title : TextView = itemView.findViewById(R.id.title)
        private val author : TextView = itemView.findViewById(R.id.author)
        private val publisher : TextView = itemView.findViewById(R.id.publisher)
        private val discount : TextView = itemView.findViewById(R.id.discount)

        fun bind(item: bookItem){
            Glide.with(context)
                .load(item.image)
                .override(SIZE_ORIGINAL)
                .into(ImageUrl)
            title.text = item.title
            author.text = item.author
            publisher.text = item.publisher
            discount.text = item.discount.toString()
        }
    }


}