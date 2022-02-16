package com.alireza.hw12.qes2Score

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.alireza.hw12.R
import com.alireza.hw12.databinding.PhotoRecyclerItemBinding

class RecyclerPhotoItem(var photoItem: MutableList<Photo>): RecyclerView.Adapter<PhotoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {


        val inflater= LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<PhotoRecyclerItemBinding>(inflater, R.layout.photo_recycler_item,parent,false)
        return PhotoHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {

        val photo = photoItem[position]
        holder.photoRecyclerItemBinding.photo = photo
    }

    override fun getItemCount(): Int {
        return photoItem.size
    }
}