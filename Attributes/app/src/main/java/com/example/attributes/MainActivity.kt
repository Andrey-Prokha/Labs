package com.example.attributes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_black = findViewById<View>(R.id.button_black) as Button
        val button_red = findViewById<View>(R.id.button_red) as Button
        val button_8sp = findViewById<View>(R.id.button_8sp) as Button
        val button_24sp = findViewById<View>(R.id.button_24sp) as Button
        val button_white = findViewById<View>(R.id.button_white) as Button
        val button_yellow = findViewById<View>(R.id.button_yellow) as Button

        val EditText = findViewById<View>(R.id.editText) as EditText

        button_black.setOnClickListener(View.OnClickListener {
            EditText.setTextColor(Color.BLACK)
        })

        button_red.setOnClickListener(View.OnClickListener {
            EditText.setTextColor(Color.RED)
        })

        button_8sp.setOnClickListener(View.OnClickListener {
            EditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8F)
        })

        button_24sp.setOnClickListener(View.OnClickListener {
            EditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)
        })

        button_white.setOnClickListener(View.OnClickListener {
            EditText.setBackgroundColor(Color.WHITE)
        })

        button_yellow.setOnClickListener(View.OnClickListener {
            EditText.setBackgroundColor(Color.YELLOW)
        })
    }
}