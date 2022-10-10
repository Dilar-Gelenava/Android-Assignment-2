package com.example.android_assignment_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val result = intent.getStringExtra("result")

        val resultView = findViewById<TextView>(R.id.result)
        resultView.text = result

        val back = findViewById<TextView>(R.id.back)

        back.setOnClickListener {
            finish()
        }
    }
}