package com.example.videoplayer.login

import android.app.Activity
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.videoplayer.Fragment.OtherFragment
import com.example.videoplayer.MainActivity
import com.example.videoplayer.R
import com.example.videoplayer.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignInBinding
    lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()


        //belum punya akun
        binding.txtCreateaccount.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        //Login
        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                binding.barBuff.visibility = View.VISIBLE
                binding.signinLayout.visibility = View.INVISIBLE
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {

                    if (it.isSuccessful){
                        Toast.makeText(this,"Masuk",Toast.LENGTH_SHORT).show()
                        readData(password)
                        binding.txtinputPassword.isErrorEnabled = false
                        binding.txtinputEmail.isErrorEnabled = false
                        binding.barBuff.visibility = View.INVISIBLE
                        binding.signinLayout.visibility = View.VISIBLE
                    } else {
                        Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
                        binding.barBuff.visibility = View.INVISIBLE
                        binding.signinLayout.visibility = View.VISIBLE
                    }

                }
            } else if (email.isEmpty()){
            binding.txtinputEmail.isErrorEnabled = true
            binding.txtinputEmail.error = "White space is not allowed"
            binding.txtinputPassword.isErrorEnabled = false
            }
            else if (password.isEmpty()){
            binding.txtinputPassword.isErrorEnabled = true
            binding.txtinputEmail.isErrorEnabled = false
            binding.txtinputPassword.error = "White space is not allowed"

        }
            else {
                Toast.makeText(this,"Empty field not allowed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(email: String) {
        database = FirebaseDatabase.getInstance().getReference("users")
        database.child(email).get().addOnSuccessListener {
            if (it.exists()){
                val emaill= it.child("email").value.toString()
                val username = it.child("username").value.toString()
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("username",username)
                startActivity(intent)
            }
        }
    }
}