
package com.example.gson

import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import timber.log.Timber
import java.io.IOException
import java.net.URL

interface CellClickListener {
    fun onCellClickListener(url: String)
}

interface CallBack{
    fun onResult(UrlList: ArrayList<String>)
}

class MainActivity : AppCompatActivity(), CellClickListener, CallBack {
    private val URL:URL = URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        val get = Get()
        get.get(URL,  this)
    }

    override fun onResult(UrlList: ArrayList<String>) {
        runOnUiThread{
            val recyclerView: RecyclerView = findViewById(R.id.rView)
            recyclerView.layoutManager = GridLayoutManager(this,2)
            recyclerView.adapter = Adapter(this, UrlList, this)
        }
    }

    override fun onCellClickListener(url: String) {
       val clipboardManager = this.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val clipData = ClipData.newPlainText("text", url)
        clipboardManager.setPrimaryClip(clipData)
        Timber.i(url)
    }
}

class Get {
    val OkHttpClient = OkHttpClient()

    fun get(Url:URL, callback: CallBack){
        val UrlList = ArrayList<String>()
        val request: Request = Request.Builder().url(Url).build()

        OkHttpClient.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string()
                val wrapper = Gson().fromJson(json, Wrapper::class.java)
                for (i in 0 until wrapper.photos.photo.count()) {
                    UrlList += ("https://farm${wrapper.photos.photo[i].farm}.staticflickr.com/${wrapper.photos.photo[i].server}/${wrapper.photos.photo[i].id}_${wrapper.photos.photo[i].secret}_z.jpg")
                }
                callback.onResult(UrlList)
            }
        })
    }
}

data class Photo (
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    val ispublic: Number,
    val isfriend: Number,
    val isfamily: Number
)

data class PhotoPage (
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    val photo: Array<Photo>
)

data class Wrapper (
    val photos: PhotoPage,
    val stat: String
)