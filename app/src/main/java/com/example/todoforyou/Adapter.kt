package com.example.todoforyou

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoforyou.databinding.ActivityMainBinding
import com.example.todoforyou.databinding.ViewBinding

class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    lateinit var binding: Adapter


    class MyViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val text = holder.binding.nomi.text.toString()
    }

    override fun getItemCount(): Int {
        return 1000
    }
}