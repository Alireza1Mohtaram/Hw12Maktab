package com.alireza.hw12.qes1.models

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.alireza.hw12.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieHandler(fragment: Fragment) {


   private val dataHolder: DataHolder by fragment.activityViewModels()


    fun addMovie(title: String, favState: Fav, uri: String?) {
        dataHolder.movieList.add(Movie(dataHolder.idInc, title, favState, uri))
        dataHolder.idInc = dataHolder.idInc + 1
    }
    fun addMovies(movies: MutableList<Movie>) {
       for (i in 0 until movies.size){
           dataHolder.movieList.add(Movie(dataHolder.idInc, movies[i].title, movies[i].favState, movies[i].posterId))
        }

    }

    fun getItemCount(): Int = dataHolder.movieList.count()
     fun getMovieWithItem(id: Int) : Movie {
        return dataHolder.movieList.filter { movie -> movie.id == id } [0]

    }
    fun setFav(id:Int , favState : Fav) {
        getMovieWithItem(id).favState = favState
    }
    fun changeFavState(id: Int) : Fav {
        return if (getMovieWithItem(id).favState == Fav.NOFAV) {
            setFav(id, Fav.ISFAV)
            Fav.ISFAV
        } else {
            setFav(id, Fav.NOFAV)
            Fav.NOFAV
        }
    }
    fun getFavs():MutableList<Movie>{
        return dataHolder.movieList.filter { m -> m.favState == Fav.ISFAV } as MutableList<Movie>   }


    fun getAllMovies(): MutableList<Movie> {
        return dataHolder.movieList
    }


}