package com.alireza.hw12.qes1.models

import androidx.lifecycle.ViewModel

public class DataHolder : ViewModel() {

    var idInc :Int = 0
    var movieList = mutableListOf<Movie>()
}