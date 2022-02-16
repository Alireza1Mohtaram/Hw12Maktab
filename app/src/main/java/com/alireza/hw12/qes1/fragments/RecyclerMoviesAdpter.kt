package com.alireza.hw12.qes1.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.alireza.hw12.R
import com.alireza.hw12.databinding.FavRecyclerItemBinding
import com.alireza.hw12.qes1.models.Movie
import com.google.android.material.imageview.ShapeableImageView

class RecyclerMoviesAdpter(movies:MutableList<Movie>): RecyclerView.Adapter<RecyclerMoviesAdpter.RecyclerItemAdapter> (){

    var moviesItem = movies
    inner class RecyclerItemAdapter(val favRecyclerItemBinding: FavRecyclerItemBinding) : RecyclerView.ViewHolder(favRecyclerItemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemAdapter {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val movieItem = DataBindingUtil.inflate<FavRecyclerItemBinding>(inflater,R.layout.fav_recycler_item,parent,false)
        return RecyclerItemAdapter(movieItem)

    }

    override fun onBindViewHolder(holder: RecyclerItemAdapter, position: Int) {

        val m = moviesItem[position]
       holder.favRecyclerItemBinding.movie = m
    }

    override fun getItemCount(): Int {
    return moviesItem.size
    }


}

