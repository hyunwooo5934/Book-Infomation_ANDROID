package com.example.book.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.example.book.R
import com.example.book.data.local.searchWord
import com.example.book.ui.detail.DetailActivity
import com.example.book.data.model.bookItem
import com.example.book.util.reSearchClick

class searchWordAdapter(private val context : Context, listener : reSearchClick) : RecyclerView.Adapter<searchWordAdapter.viewHolder>() {

    var datas = mutableListOf<searchWord>()

    private val mCallback = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.worditem,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(datas.get(position))
    }

    fun update(items : List<searchWord>) {
        datas = items.toMutableList()
        notifyDataSetChanged()
    }

    inner class viewHolder(view : View) : RecyclerView.ViewHolder(view){

        private val wordTxt : TextView = itemView.findViewById(R.id.wordTxt)
        private val delBtn : TextView = itemView.findViewById(R.id.delBtn)


        fun bind(item: searchWord){

            wordTxt.text = item.word

            delBtn.setOnClickListener {
                // 삭제로직
            }

            itemView.setOnClickListener {
                // 재검색
                mCallback.reSearch(item.word)
            }


        }

    }


}