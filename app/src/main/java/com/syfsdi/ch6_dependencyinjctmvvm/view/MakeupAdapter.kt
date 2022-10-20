package com.syfsdi.ch6_dependencyinjctmvvm.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.syfsdi.ch6_dependencyinjctmvvm.databinding.ItemMakeupBinding
import com.syfsdi.ch6_dependencyinjctmvvm.model.ResponseDataMakeupItem

class MakeupAdapter(var listmakeup : List<ResponseDataMakeupItem>): RecyclerView.Adapter<MakeupAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemMakeupBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemMakeupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint position: Int) {
    holder.binding.nameMakeUp.text =listmakeup[position].name
    holder.binding.priceMakeup.text = listmakeup[position].name
    holder.binding.brandMakeup.text = listmakeup[position].name
    Glide.with(holder.itemView.context)
        .load(listmakeup[position].imageLink)
        .into(holder.binding.imgMakeup)
    }

    override fun getItemCount(): Int = listmakeup.size

}