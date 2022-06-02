package com.example.todoforyou

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoforyou.databinding.ActivityMainBinding

class Adapter : RecyclerView.Adapter<Adapter.viewHolder>() {
    lateinit var binding: Adapter
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var title=itemView.title.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView=LayoutInflater.from(parent.context).
        inflate(R.layout.view,parent,false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}