package com.example.videoplayer.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.videoplayer.Adapter.ViewPager
import com.example.videoplayer.R
import com.example.videoplayer.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewPagerBinding
    private var titleList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()
    private var descList = mutableListOf<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postTolist()
        binding.viewpager.adapter = ViewPager(imageList,titleList,descList)
        binding.circleIndicator.setViewPager(binding.viewpager)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun addToList(title : String,desc:String,image : Int){
        titleList.add(title)
        imageList.add(image)
    }

    private fun postTolist() {
        addToList("Lorem Ipsum","aaaaaaa",R.drawable.vp1)
        addToList("Lorem Ipsum","bbbbbbb",R.drawable.vp2)
    }
}