package com.alireza.hw12.qes2Score
//
//import android.widget.ImageView
//import androidx.databinding.BindingAdapter
//import androidx.swiperefreshlayout.widget.CircularProgressDrawable
//import com.alireza.hw12.R
//import com.alireza.hw12.qes1.models.Fav
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.RequestOptions
//@BindingAdapter("imageUrl")
//fun loadImage(imageView: ImageView, imageURL: String?) {
//
//    val circularProgressDrawable = CircularProgressDrawable(imageView.context)
//    circularProgressDrawable.strokeWidth = 5f
//    circularProgressDrawable.centerRadius = 30f
//    circularProgressDrawable.start()
//
//    if (!imageURL.isNullOrBlank()) {
//        Glide.with(imageView.context)
//            .setDefaultRequestOptions(RequestOptions.fitCenterTransform())
//            .load(imageURL)
//            .placeholder(R.drawable.ic_launcher_foreground)
//            .into(imageView);
//    }
//
//}
//@BindingAdapter("favState")
//fun loadState(imageView: ImageView, favState: Fav) {
//
//    if (favState == Fav.ISFAV) {
//        imageView.setImageResource(R.drawable.ic_baseline_favorite_24)
//    } else
//        imageView.setImageResource(R.drawable.ic_baseline_favorite_border_24)
//
//}