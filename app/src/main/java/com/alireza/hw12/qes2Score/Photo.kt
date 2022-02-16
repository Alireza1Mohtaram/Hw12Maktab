package com.alireza.hw12.qes2Score

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alireza.hw12.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

data class Photo(
    var id: String,
    var author: String,
    var width: Int,
    var height: Int,
    val url: String,
    val download_url: String
) {

    companion object {
        @BindingAdapter("imageUrl")
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
    }
}


