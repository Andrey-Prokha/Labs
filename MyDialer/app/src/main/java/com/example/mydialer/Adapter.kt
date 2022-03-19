package com.example.mydialer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(
    private val context: Context,
    private var list: Array<Contact>,
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val TextName: TextView = view.findViewById(R.id.textName)
        val TextPhone: TextView = view.findViewById(R.id.textPhone)
        val TextType: TextView = view.findViewById(R.id.textType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.TextName.text = data.name
        holder.TextPhone.text = data.phone
        holder.TextType.text = data.type
    }

    fun updateData(contacts: Array<Contact>) {
        list = contacts
        notifyDataSetChanged()
    }
}