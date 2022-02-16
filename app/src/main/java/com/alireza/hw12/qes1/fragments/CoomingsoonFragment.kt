package com.alireza.hw12.qes1.fragments

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alireza.hw12.R
import com.alireza.hw12.databinding.CoomingsoonFragmentLayoutBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

class CoomingsoonFragment : Fragment(R.layout.coomingsoon_fragment_layout) {


    lateinit var binding: CoomingsoonFragmentLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = CoomingsoonFragmentLayoutBinding.bind(view)

        loadImage(binding.imageView1,"https://picsum.photos/seed/200/300")
        loadImage(binding.imageView2,"https://picsum.photos/seed/200/300")
        loadImage(binding.imageView3,"https://picsum.photos/seed/200/300")

        binding.btnShare1.setOnClickListener {

            sendMovie(
                binding.titleSoonFragment1.text.toString(),
                binding.descSoonFragment1.text.toString()
            )
        }

        binding.btnShare2.setOnClickListener {
            sendMovie(
                binding.titleSoonFragment2.text.toString(),
                binding.descSoonFragment2.text.toString()
            )
        }

        binding.btnShare3.setOnClickListener {
            sendMovie(
                binding.titleSoonFragment3.text.toString(),
                binding.descSoonFragment3.text.toString()
            )
        }
    }
    private fun sendMovie(title: String, desc: String) {

        val i = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "$title \n $desc")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(i,"movie"))
    }

    private fun loadImage(imageView: ImageView, imageURL: String?) {
        if (!imageURL.isNullOrBlank()) {
            Glide.with(imageView.context)
                .setDefaultRequestOptions(RequestOptions.fitCenterTransform())
                .load(imageURL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView);
        }
    }

    override fun onResume() {
        super.onResume()

    }
}