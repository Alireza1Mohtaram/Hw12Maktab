package com.alireza.hw12.qes2Score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.alireza.hw12.R
import com.alireza.hw12.databinding.ActivityGallertAppBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.Reader
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

class GalleyApp : AppCompatActivity() {

    private val clinet by lazy {OkHttpClient()}
    lateinit var binding : ActivityGallertAppBinding
    private val executer by lazy {Executors.newSingleThreadExecutor()}
    private val requestUrl:String ="https://picsum.photos/v2/list?limit=20"
    lateinit var request:Request



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_gallert_app)

        responseToObject(load())

    }
    private fun load(): String {
    Log.d("Data","load is running")
        request = Request.Builder().url(requestUrl).build()
        var responseBody:String=""
        val future : Future<String>
        try {
            future = executer.submit(Callable<String> {
                val call = clinet.newCall(request)
                val response = call.execute()
                response.body?.let { Log.d("Res", it.string()) }
                response.body.toString()
            })
           // if (future.isDone)
            responseBody = future.get()
           // else responseBody = "Nodata"

        }catch (e:Exception){
            println(e.message)
        }
        Log.d("Data","load is done")
        Log.d("Res",responseBody)
        return responseBody
    }

    fun responseToObject(response:String):MutableList<Photo>{
        Log.d("Data","response is running")

        var resArray = Gson().toJson(response)
        val gson = Gson()
        val listOfPhoto = mutableListOf<Photo>()

        Log.d("Data",resArray)
        println(resArray.toString())
        return listOfPhoto
    }

}