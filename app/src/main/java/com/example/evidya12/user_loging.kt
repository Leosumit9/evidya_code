package com.example.evidya12

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.evidya12.databinding.ActivityUserLogingBinding
import com.example.evidya12.databinding.ActivityUserRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class user_loging : AppCompatActivity() {

    private lateinit var binding: ActivityUserLogingBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserLogingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, user_loging::class.java)
            startActivity(intent)
        }

        binding.createAccount.setOnClickListener{
            val intent = Intent(this, user_register::class.java)
            startActivity(intent)
        }

        binding.loginButton.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {


                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, sel_learn_quiz_page::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }

                }


            } else {
                Toast.makeText(this, "Empty fields is not allowed ", Toast.LENGTH_SHORT).show()
            }


        }
    }

    override fun onStart() {
        super.onStart()

        if (firebaseAuth.currentUser != null){
            val intent = Intent(this, sel_learn_quiz_page::class.java)
            startActivity(intent)
        }
    }
}