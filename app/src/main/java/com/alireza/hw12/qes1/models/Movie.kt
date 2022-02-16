package com.alireza.hw12.qes1.models

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alireza.hw12.R
import com.alireza.hw12.qes1.fragments.HomeFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Movie() {

    var id: Int = 0
    var title: String = "No title"
        set(value) {
            field = if (field.isNotBlank()) value
            else "No title"
        }
    var favState: Fav = Fav.NOFAV
    var posterId: String? = null


    constructor(id: Int, title: String, favState: Fav, posterId: String?) : this() {
        this.id = id
        this.title = title
        this.favState = favState
        this.posterId = posterId
    }

    override fun toString(): String {
        return "Movie(id=$id, title='$title', favState=$favState, posterId=$posterId)"
    }

    companion object {
        @BindingAdapter("poster")
        @JvmStatic
        fun loadImage(imageView: ImageView, imageURL: String?) {
            if (!imageURL.isNullOrBlank()) {
                Glide.with(imageView.context)
                    .setDefaultRequestOptions(RequestOptions.fitCenterTransform())
                    .load(imageURL)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(imageView);
            }
        }

        @JvmStatic
        @BindingAdapter("favState")
        fun loadState(imageView: ImageView, favState: Fav) {

            if (favState == Fav.ISFAV) {
                imageView.setImageResource(R.drawable.ic_baseline_favorite_24)
            } else
                imageView.setImageResource(R.drawable.ic_baseline_favorite_border_24)

        }

//        @JvmStatic
//        @BindingAdapter("onClickFavState")
//            fun onClickFavState(imageView: ImageView, favState: Fav) {
//            imageView.setOnClickListener{
//                val fav = MovieHandler(HomeFragment()).changeFavState(id = 0)
//                if (fav == Fav.ISFAV) loadState(imageView, Fav.NOFAV)
//                else  loadState(imageView, Fav.ISFAV)
//
//            }
//            }

    }
}