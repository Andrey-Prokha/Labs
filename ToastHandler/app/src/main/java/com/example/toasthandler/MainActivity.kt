package com.example.toasthandler

import android.app.Application
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_ok = findViewById<View>(R.id.button_ok) as Button;
        button_ok.setOnClickListener(View.OnClickListener {
           val Toast = Toast.makeText(applicationContext, "Кнопка ок", Toast.LENGTH_SHORT).show();
        })
    }
}