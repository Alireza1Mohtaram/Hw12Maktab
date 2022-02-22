package com.alireza.hw12.qes2Score

import android.os.Bundle
import android.os.Handler
import android.util.JsonReader
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alireza.hw12.R
import com.alireza.hw12.databinding.ActivityGallertAppBinding
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future


class GalleyApp : AppCompatActivity() {

    private val clinet by lazy {
        OkHttpClient()
    }
    lateinit var binding: ActivityGallertAppBinding
    private val executer by lazy { Executors.newSingleThreadExecutor() }
    private val requestUrl: String = "https://picsum.photos/v2/list?limit=10"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gallert_app)

        load()
    }
    private fun load(): String {
        Log.d("Data", "load is running")
        val  request = Request.Builder().url(requestUrl).build()
        val client = OkHttpClient()
        var responseStr:String =""
        val call = client.newCall(request)
          call.enqueue(object  : Callback {
               override fun onFailure(call: Call, e: IOException) {
                   setResult( e.toString() )
                    Log.d("Data",e.toString())
               }
               override fun onResponse(call: Call, response: Response) {
                   response.body?.string()?.let { responseToObject(it) }
                    Log.d("Data","Null call back")
               }
           })

      return responseStr
    }

    private fun responseToObject(response: String) {

        Log.d("Data", "response is $response")


        val resArray = Gson().toJson(response)
       // Log.d("Data", "resArray$resArray")

        val jsonObject = JSONObject(response)
        var jsonArray = jsonObject.getJSONArray("")
        Log.d("Data", "resArray$jsonArray")

       // return jsonArray.getJSONObject(0)
    }
    fun setResult(data :String?){
        runOnUiThread{
            if (data != null) {
                responseToObject(data)
            }
        }
    }

}