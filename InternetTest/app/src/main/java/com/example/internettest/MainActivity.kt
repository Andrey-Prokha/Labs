package com.example.internettest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.net.HttpURLConnection
import java.net.URL
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val url:URL = URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")
    private val tag:String = "Flickr cats"
    private val tagOkHttp:String = "Flickr OkCats"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHTTP:Button = findViewById(R.id.btnHTTP)
        val bthOkHTTP:Button = findViewById(R.id.btnOkHTTP)
        btnHTTP.setOnClickListener(View.OnClickListener {
            val runnable = Runnable {
                val urlConnection = url.openConnection() as HttpURLConnection
                try {
                    val data: String =
                        urlConnection.inputStream.bufferedReader().use { it.readText() }
                    Log.i(tag, data)
                } finally {
                    urlConnection.disconnect()
                }
            }
            val thread = Thread(runnable)
            thread.start()
        })
        bthOkHTTP.setOnClickListener(View.OnClickListener {
            getData()
        })
    }

    private fun getData() {
        val client = OkHttpClient()
        val request:Request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                val data: String? = response?.body?.string()
                if (data != null) {
                    Log.i(tagOkHttp, data)
                }
            }
        })
    }
}