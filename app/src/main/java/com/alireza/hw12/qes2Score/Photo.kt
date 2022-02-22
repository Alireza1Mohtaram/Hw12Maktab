package com.alireza.hw12.qes2Score

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alireza.hw12.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName

data class Photo(
@SerializedName("author")
val author: String,
@SerializedName("download_url")
val download_url: String,
@SerializedName("height")
val height: Int,
@SerializedName("id")
val id: String,
@SerializedName("url")
val url: String,
@SerializedName("width")
val width: Int
)


