package com.example.videoplayer.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.videoplayer.MainActivity
import com.example.videoplayer.databinding.ActivitySignUpBinding
import com.example.videoplayer.dataclass.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()


        //already have account
        binding.txtHaveaccount.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

        //Create Account
        binding.btnCreateAccount.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()

            if (email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                binding.barBuff.visibility = View.VISIBLE
                binding.signupLayout.visibility = View.INVISIBLE

                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {task ->

                    try {
                        if (task.isSuccessful){
                            database = FirebaseDatabase.getInstance().getReference("users")
                            val user = User(username,email,password)
                            database.child(password).setValue(user).addOnCompleteListener {
                                Log.d("TAG","Succes Save Data $user")
                            }
                            Toast.makeText(this,"Succes create account",Toast.LENGTH_SHORT).show()
                            val intent = Intent(this,SignInActivity::class.java)
                            startActivity(intent)
                            finish()
                            binding.barBuff.visibility = View.INVISIBLE
                            binding.signupLayout.visibility = View.VISIBLE

                        } else {
                            Log.d("TAG","The issue is:${task.exception}")
                            binding.txtinputPassword.isErrorEnabled = false
                            binding.txtinputEmail.isErrorEnabled = false
                            binding.txtinputUsername.isErrorEnabled = false
                            Toast.makeText(this,"Something wrong,cant create account",Toast.LENGTH_SHORT).show()
                            binding.barBuff.visibility = View.INVISIBLE
                            binding.signupLayout.visibility = View.VISIBLE
                        }
                    } catch (e: Exception){
                        Toast.makeText(this,"Email already used",Toast.LENGTH_SHORT).show()
                        binding.barBuff.visibility = View.INVISIBLE
                        binding.signupLayout.visibility = View.VISIBLE
                    }

                }

            } else if (username.isEmpty()){
                binding.txtinputUsername.isErrorEnabled = true
                binding.txtinputEmail.isErrorEnabled = false
                binding.txtinputPassword.isErrorEnabled = false
                binding.txtinputUsername.error = "White space is not allowed"
            } else if (email.isEmpty()){
                binding.txtinputEmail.isErrorEnabled = true
                binding.txtinputEmail.error = "White space is not allowed"
                binding.txtinputUsername.isErrorEnabled = false
                binding.txtinputPassword.isErrorEnabled = false
            }
              else if (password.isEmpty()){
                binding.txtinputPassword.isErrorEnabled = true
                binding.txtinputEmail.isErrorEnabled = false
                binding.txtinputUsername.isErrorEnabled = false
                binding.txtinputPassword.error = "White space is not allowed"

              }
            else {
                Toast.makeText(this,"Empty field not allowed!",Toast.LENGTH_SHORT).show()
            }
        }


    }
}