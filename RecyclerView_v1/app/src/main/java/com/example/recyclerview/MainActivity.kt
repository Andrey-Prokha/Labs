package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this, fetchList())
    }
    private fun fetchList(): ArrayList<ColorData> {
        val list = arrayListOf<ColorData>(
            ColorData("White", R.color.white),
            ColorData("Black", R.color.black),
            ColorData("Blue", R.color.blue),
            ColorData("Red", R.color.red),
            ColorData("Magenta", R.color.magenta)
        )
        return list
    }
}
data class ColorData (
    val colorName: String,
    val ColorHex: Int
)