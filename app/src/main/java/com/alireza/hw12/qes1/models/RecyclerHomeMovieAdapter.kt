package com.alireza.hw12.qes1.models

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.alireza.hw12.R
import com.alireza.hw12.databinding.HomeRecyclerItemBinding
import com.alireza.hw12.qes1.models.Fav
import com.alireza.hw12.qes1.fragments.HomeFragment
import com.alireza.hw12.qes1.models.HomeHolder
import com.alireza.hw12.qes1.models.Movie
import com.alireza.hw12.qes1.models.MovieHandler
import com.google.android.material.imageview.ShapeableImageView
import kotlin.math.log

class RecyclerHomeMovieAdapter (movies:MutableList<Movie>, var fragment: HomeFragment): RecyclerView.Adapter<HomeHolder>() {

    var moviesItem = movies
    lateinit var movieHandler: MovieHandler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<HomeRecyclerItemBinding>(inflater,R.layout.home_recycler_item,parent,false)
        return HomeHolder(binding)

    }
    override fun onBindViewHolder(holder: HomeHolder, position: Int) {

        val m = moviesItem[position]
        movieHandler = MovieHandler(fragment)
        holder.itemViewBinding.movie = m
        holder.itemViewBinding.likeBtnHomeItem.setOnClickListener{
                m.favState = movieHandler.changeFavState(position)
                holder.itemViewBinding.movie = m
                Log.d("Data","$m")

        }

    }

    override fun getItemCount(): Int {
        return moviesItem.size
    }

//    private fun updateFavoriteState(id: Int, btn: ShapeableImageView) {
//        val fav = movieHandler.changeFavState(id)
//        btn.changeSate(fav)
//    }

//    private fun ShapeableImageView.changeSate(fav: Fav) {
//        if (fav == Fav.ISFAV) this.setImageResource(R.drawable.ic_baseline_favorite_24)
//        else this.setImageResource(R.drawable.ic_baseline_favorite_border_24)
//    }

}