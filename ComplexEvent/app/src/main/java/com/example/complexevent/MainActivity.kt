package com.example.complexevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<View>(R.id.button) as Button
        val EditText = findViewById<View>(R.id.editText) as EditText
        val checkBox = findViewById<View>(R.id.checkBox) as CheckBox
        val textView = findViewById<View>(R.id.textView) as TextView
        val progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
        progressBar.max = 100

        button.setOnClickListener(View.OnClickListener {
            progressBar.progress = progressBar.progress + 10
            if (checkBox.isChecked){
                textView.text = EditText.text
            }
        })
    }
}