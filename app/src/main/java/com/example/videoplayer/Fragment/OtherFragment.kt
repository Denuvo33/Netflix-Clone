package com.example.videoplayer.Fragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.videoplayer.R
import com.example.videoplayer.databinding.FragmentOtherBinding
import com.example.videoplayer.login.SignInActivity
import com.google.firebase.auth.FirebaseAuth


class OtherFragment : Fragment() {

    lateinit var binding : FragmentOtherBinding
    lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        binding = FragmentOtherBinding.inflate(layoutInflater)
        val data  = arguments
        binding.txtEmail.text = auth.currentUser!!.email.toString()
        binding.txtUsername.text = data!!.get("username").toString()

        binding.btnLogout.setOnClickListener {
            auth.signOut()
            val intent = Intent(activity,SignInActivity::class.java)
            startActivity(intent)
            this.activity?.finish()
        }



        return binding.root
    }


}