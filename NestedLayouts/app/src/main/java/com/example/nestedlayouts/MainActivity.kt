package com.example.nestedlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewGroup = findViewById<View>(R.id.main) as ViewGroup

        val roll = findViewById<View>(R.id.button) as Button

        val textview = findViewById<View>(R.id.textView1) as TextView

        val text = textview.text as String
        var count = text.toInt()

        roll.setOnClickListener(View.OnClickListener {
            count++
            for (i in 0..2) {
                val layout = mainViewGroup.getChildAt(i) as ViewGroup
                for (j in 0..2){
                    val textView = layout.getChildAt(j) as TextView
                    if(TextUtils.equals(textView.text, (count - 1).toString())){
                        textView.text = ""
                        if (j == 2) {
                            val textViewNew = layout.getChildAt(0) as TextView
                            textViewNew.text = count.toString()
                        } else{
                            val textViewNew = layout.getChildAt(j+1) as TextView
                            textViewNew.text = count.toString()
                        }
                    }
                }
            }
        })
    }
}