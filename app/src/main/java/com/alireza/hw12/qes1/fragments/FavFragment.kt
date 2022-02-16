package com.alireza.hw12.qes1.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.alireza.hw12.R
import com.alireza.hw12.databinding.FavFragmentBinding
import com.alireza.hw12.qes1.models.MovieHandler

class FavFragment : Fragment(R.layout.fav_fragment) {

    private lateinit var binding : FavFragmentBinding
    private lateinit var movieHandler : MovieHandler


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FavFragmentBinding.bind(view)
        movieHandler = MovieHandler(this)

    }
    private fun setFavoriteItems() {
        val list = movieHandler.getFavs()
        val adapter= RecyclerMoviesAdpter(list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
    }

    override fun onResume() {
        super.onResume()
        setFavoriteItems()
    }
}