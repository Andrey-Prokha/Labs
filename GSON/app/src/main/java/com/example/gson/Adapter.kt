package com.example.gson

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(private val context: Context,
              private val list: ArrayList<String>,
              private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = list[position]
        Picasso.get().load(url).resize(180, 180).centerCrop().placeholder(R.drawable.ic_launcher_foreground).into(holder.imageView);
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(url)
        }
    }
}