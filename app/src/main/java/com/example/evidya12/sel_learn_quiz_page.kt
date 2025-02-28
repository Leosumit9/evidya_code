package com.example.evidya12

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.evidya12.com.example.evidya12.choose_class
import com.example.evidya12.com.example.evidya12.quiz_page

class sel_learn_quiz_page: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sel_learn_quiz_page)

        val learning_btn = findViewById<Button>(R.id.learning_btn)
        learning_btn.setOnClickListener{
            val intent = Intent(this, choose_class::class.java)
            startActivity(intent)
        }

        val quiz_btn = findViewById<Button>(R.id.quiz_btn)
        quiz_btn.setOnClickListener{
            val intent = Intent(this, quiz_page::class.java)
            startActivity(intent)
        }

    }
}