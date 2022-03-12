package com.example.logging

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val TAG = "From EditText"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_log = findViewById<View>(R.id.button_log) as Button
        button_log.setOnClickListener(View.OnClickListener {
            val text_view = findViewById<View>(R.id.textView) as EditText
            val text = text_view.text.toString()
            Log.i(TAG, text)
        })

        Timber.plant(Timber.DebugTree())

        val button_timber = findViewById<View>(R.id.button_timber) as Button
        button_timber.setOnClickListener(View.OnClickListener {
            val text_view = findViewById<View>(R.id.textView) as EditText
            val text = text_view.text.toString()
            Timber.v(text)
        })

    }
}