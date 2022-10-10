package com.example.android_assignment_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1View = findViewById<TextView>(R.id.number1);
        val number2View = findViewById<TextView>(R.id.number2);

        val multiplicationButton = findViewById<Button>(R.id.multiply);
        val additionButton = findViewById<Button>(R.id.add);
        val subtractionButton = findViewById<Button>(R.id.subtract);
        val divisionButton = findViewById<Button>(R.id.divide);

        fun operate(op: String) {

            try {
                val number1 = number1View.text.toString().toDouble()
                val number2 = number2View.text.toString().toDouble()
                var result = 0.0
                when (op) {
                    "+" -> result = number1 + number2
                    "-" -> result = number1 - number2
                    "*" -> result = number1 * number2
                    "/" -> result = number1 / number2
                }
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("result", result.toString())
                startActivity(intent)
            } catch (e: Exception) {
                println(e)
                Snackbar.make(
                    findViewById(R.id.main_activity),
                    "Please enter valid numbers",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        multiplicationButton.setOnClickListener {
            operate("*")
        }
        additionButton.setOnClickListener {
            operate("+")
        }
        subtractionButton.setOnClickListener {
            operate("-")
        }
        divisionButton.setOnClickListener {
            operate("/")
        }
    }


}