package com.example.evidya12

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.evidya12.ChooseClass
import com.example.evidya12.Quiz

class SelPageLP: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sel_learn_quiz_page)

        val learning_btn = findViewById<Button>(R.id.learning_btn)
        learning_btn.setOnClickListener{
            val intent = Intent(this, ChooseClass::class.java)
            startActivity(intent)
        }

        val quiz_btn = findViewById<Button>(R.id.quiz_btn)
        quiz_btn.setOnClickListener{
            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)
        }

    }
}