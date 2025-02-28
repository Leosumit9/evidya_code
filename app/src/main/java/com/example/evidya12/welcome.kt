//package com.example.evidya12
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//
//
//class Welcome: AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.welcome)
//
//        val textView = findViewById<TextView>(R.id.getstart)
//        textView.setOnClickListener{
//            val intent = Intent(this, login_page::class.java)
//            startActivity(intent)
//        }
//
//
//
//    }
//}

package com.example.evidya12.com.example.evidya12

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.evidya12.R
import com.example.evidya12.user_loging

class Welcome : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome)

        // 🔹 Handle button click to navigate to LoginPage activity
        val textView = findViewById<TextView>(R.id.getstart)
        textView.setOnClickListener {
            val intent = Intent(this, user_loging::class.java)
            startActivity(intent)
        }



        // 🔹 Handle Spinner for language selection
        val spinner = findViewById<Spinner>(R.id.spinner)
        val languages = resources.getStringArray(R.array.languages)

        // 🔹 Custom Adapter for Bold Text
        val adapter = ArrayAdapter(this, R.layout.spinner_items, languages)
        adapter.setDropDownViewResource(R.layout.spinner_items)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                // TODO: Handle language selection logic
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}





