package com.example.evidya12

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.evidya12.databinding.ActivityUserRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class UserRegister : AppCompatActivity() {

    private lateinit var binding: ActivityUserRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityUserRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signup.setOnClickListener{

            val  name = binding.name.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val password_2 = binding.repassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && password_2.isNotEmpty()){
                if (password == password_2){
                    firebaseAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, UserLogin::class.java)
                            startActivity(intent)

                        }else{
                            Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()

                        }

                    }

                }else{
                    Toast.makeText(this, "password is not matching" , Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Empty fields is not allowed " , Toast.LENGTH_SHORT).show()

            }
        }



    }

}