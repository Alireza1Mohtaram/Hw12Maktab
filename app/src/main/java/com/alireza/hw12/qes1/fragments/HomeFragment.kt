package com.alireza.hw12.qes1.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.alireza.hw12.R
import com.alireza.hw12.databinding.HomeFragmentBinding
import com.alireza.hw12.qes1.models.Fav
import com.alireza.hw12.qes1.models.MovieHandler
import com.alireza.hw12.qes1.models.RecyclerHomeMovieAdapter

class HomeFragment : Fragment(R.layout.home_fragment) {
    lateinit var binding: HomeFragmentBinding
    lateinit var movieHandler: MovieHandler

    companion object {
        var isAddedRecyclerItems = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding = HomeFragmentBinding.bind(requireView())
        movieHandler = MovieHandler(this)
        initMovies(this.requireContext())

    }

    private fun initMovies(context: Context) {

        if (!isAddedRecyclerItems) {
            movieHandler.addMovie("Harry", Fav.NOFAV, "https://img.posterlounge.co.uk/images/m/1893830.jpg")
            movieHandler.addMovie("Peaky", Fav.NOFAV, "https://img.posterlounge.co.uk/images/m/1885609.jpg")
            movieHandler.addMovie("Fast ", Fav.NOFAV, "https://img.posterlounge.co.uk/images/m/1898865.jpg")
            movieHandler.addMovie("Peaky blinder", Fav.NOFAV, "https://img.posterlounge.co.uk/images/m/1885609.jpg")
        }
    }

    fun setMovies() {

        isAddedRecyclerItems = true
        binding.recyclerView2.let {
            it.adapter = RecyclerHomeMovieAdapter(movieHandler.getAllMovies(), this)
            it.layoutManager = GridLayoutManager(requireContext(), 3)

        }
    }

    override fun onResume() {
        super.onResume()
        setMovies()

    }



}