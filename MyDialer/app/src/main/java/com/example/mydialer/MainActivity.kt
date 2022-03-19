package com.example.mydialer

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import timber.log.Timber
import java.io.*

class MainActivity : AppCompatActivity() {
    private val File_Name:String = "phones.json"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        val btn_search:Button = findViewById(R.id.btn_search)

        val inputStream = this.assets.open(File_Name)
        val json: String = BufferedReader(InputStreamReader(inputStream)).use { it.readText() }.toString()
        var contacts = Gson().fromJson(json, Array<Contact>::class.java)

        val adapter = Adapter(this, contacts)
        val recyclerView: RecyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btn_search.setOnClickListener {

            val et_search: TextView = findViewById(R.id.et_search)
            val text_search = et_search.text.toString().uppercase()

            if (text_search == "") {
                adapter.updateData(contacts)
            } else {

                val contactsFound: Array<Contact> = contacts.filter { contact -> (contact.name.uppercase().contains(text_search)
                        || contact.phone.uppercase().contains(text_search)
                        || contact.type.uppercase().contains(text_search))
                }.toTypedArray()

                adapter.updateData(contactsFound)
            }
        }
    }
}

data class Contact(
    val name: String,
    val phone: String,
    val type: String
)
