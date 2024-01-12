package com.example.book.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.book.R
import com.example.book.util.reSearchClick
import com.example.domain.model.SearchWord

class searchWordAdapter(private val context : Context, listener : reSearchClick) : RecyclerView.Adapter<searchWordAdapter.viewHolder>() {

    var datas = mutableListOf<SearchWord>()

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

    fun update(items : List<SearchWord>) {
        datas = items.toMutableList()
        notifyDataSetChanged()
    }

    inner class viewHolder(view : View) : RecyclerView.ViewHolder(view){

        private val wordTxt : TextView = itemView.findViewById(R.id.wordTxt)
        private val delBtn : TextView = itemView.findViewById(R.id.delBtn)


        fun bind(item: SearchWord){

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