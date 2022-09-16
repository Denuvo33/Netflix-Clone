package com.example.videoplayer

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplayer.Adapter.ItemAdapter
import com.example.videoplayer.Adapter.ItemAdapter2
import com.example.videoplayer.Adapter.MovieData
import com.example.videoplayer.Adapter.MovieData2
import com.example.videoplayer.Fragment.*
import com.example.videoplayer.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    var myname:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        val searchFragment = SearchFragment()
        val homeFragment = HomeFragment()
        val downloadFragment = DownloadFragment()
        val nextMovie = NextMovieFragment()
        val otherFragment = OtherFragment()

        saveData(otherFragment)

        if (currentUser != null){
            loadData(otherFragment)

        } else {
            saveData(otherFragment)
            Log.d("TAG","save data : $myname")
        }

        currentFragment(homeFragment)

        binding.bottNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.beranda -> currentFragment(homeFragment)
                R.id.cari -> currentFragment(searchFragment)
                R.id.lainnya -> currentFragment(otherFragment)
                R.id.download -> currentFragment(downloadFragment)
                R.id.segera_hadir -> currentFragment(nextMovie)
            }
            true
        }

    }

    private fun saveData(fragment: Fragment) {
        val sp : SharedPreferences = getSharedPreferences("sharedpref", MODE_PRIVATE)
        val editor = sp.edit()
        if (intent.getStringExtra("username") != null){
            val username = intent.getStringExtra("username")
            myname = username.toString()
            val bundle = Bundle()
            fragment.arguments = bundle
            bundle.putString("username",myname)
            editor.putString("username",myname)
            editor.apply()
            Log.d("TAG","string extra is not null = $myname")
        } else{
            Log.d("TAG","string extra is  null = $myname")
        }

    }

    private fun loadData(fragment: Fragment) {
        val sp : SharedPreferences = getSharedPreferences("sharedpref", MODE_PRIVATE)
        val myname = sp.getString("username",null)
        val bundle = Bundle()
        fragment.arguments = bundle
        bundle.putString("username",myname)
        Log.d("TAG","load data : $myname")
    }

    private fun currentFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }

    }
}