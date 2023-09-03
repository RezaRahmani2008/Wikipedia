package com.example.wikipedia.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemExplorerBinding

class ExplorerAdapter( val data: List<ItemPost>) :
    RecyclerView.Adapter<ExplorerAdapter.ExplorerViewHolder>() {
    lateinit var binding: ItemExplorerBinding

    inner class ExplorerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(itemPost: ItemPost) {
            Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExploreMain)
            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreSubtitle.text = itemPost.txtSubtitle
            binding.txtExploreDetail.text = itemPost.txtDetail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExplorerViewHolder {
        binding = ItemExplorerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExplorerViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExplorerViewHolder, position: Int) {
        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}