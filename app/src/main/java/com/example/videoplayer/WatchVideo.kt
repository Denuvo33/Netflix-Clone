package com.example.videoplayer

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.videoplayer.Adapter.MovieData
import com.example.videoplayer.Adapter.MovieData2
import com.example.videoplayer.databinding.ActivityWatchVideoBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class WatchVideo : AppCompatActivity() {


    private lateinit var binding: ActivityWatchVideoBinding
    var isFullScreen = false
    var isLockScreen = false
    lateinit var videoSource : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWatchVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val playerView : PlayerView = findViewById(R.id.player)
        val progresBar = binding.progresBuff
        val fullScreen : ImageView = findViewById(R.id.bt_fullscreen)
        val btLockScreen : ImageView = findViewById(R.id.exo_lock)
        val controlVid1 : LinearLayout = findViewById(R.id.sec_controlvid1)
        val controlVid2 : LinearLayout = findViewById(R.id.sec_controlvid2)

        //Receive Data From Other Activity
        val movieData = intent.getParcelableExtra<MovieData>("MovieData")
        val movieData2 = intent.getParcelableExtra<MovieData2>("MovieData2")

        if (movieData != null){
            binding.txtTitle.text = movieData.movieTitle
            binding.txtRating.text = movieData.movieRating
            binding.txtDesc.text = movieData.movieDesc
            videoSource = Uri.parse(movieData.movieUrl)
        } else if (movieData2 != null){
            binding.txtTitle.text = movieData2.title2
            binding.txtRating.text = movieData2.rating2
            binding.txtDesc.text = movieData2.desc2
            videoSource = Uri.parse(movieData2.url)
        }

        //Back to other activity
        binding.btnBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btLockScreen.setOnClickListener {
            if (!isLockScreen){
                btLockScreen.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_lock_24))
                controlVid1.visibility = View.INVISIBLE
                controlVid2.visibility = View.INVISIBLE
            } else{
                btLockScreen.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_lock_open))
                controlVid1.visibility = View.VISIBLE
                controlVid2.visibility = View.VISIBLE
            }
            isLockScreen = !isLockScreen
        }

        fullScreen.setOnClickListener {
            if (!isFullScreen){
                fullScreen.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_fullscreen_exit))
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                binding.movieInfo.visibility = View.GONE
                playerView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)
                binding.btnBack.visibility = View.INVISIBLE
            } else{
                fullScreen.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_fullscreen))
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                binding.movieInfo.visibility = View.VISIBLE
                playerView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,800)
                binding.btnBack.visibility = View.VISIBLE
            }
            isFullScreen = !isFullScreen
            Log.d("TAG","TheScreen is:$isFullScreen")
        }

        val simpleExoPlayer = SimpleExoPlayer.Builder(this)
            .setSeekBackIncrementMs(5000)
            .setSeekForwardIncrementMs(5000)
            .build()
        playerView.player = simpleExoPlayer
        playerView.keepScreenOn = true
        simpleExoPlayer.addListener(object: Player.Listener{
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                if (playbackState == Player.STATE_BUFFERING){
                    progresBar.visibility = View.VISIBLE
                }else if (playbackState == Player.STATE_READY){
                    progresBar.visibility = View.GONE
                }
            }
        })
        val mediaItem = MediaItem.fromUri(videoSource)
        simpleExoPlayer.setMediaItem(mediaItem)
        simpleExoPlayer.prepare()
        simpleExoPlayer.play()
    }

    override fun onBackPressed() {
        val playerView : PlayerView = findViewById(R.id.player)
        val fullScreen : ImageView = findViewById(R.id.bt_fullscreen)
        if (isFullScreen){
            fullScreen.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_baseline_fullscreen))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            binding.movieInfo.visibility = View.VISIBLE
            playerView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,800)
            binding.btnBack.visibility = View.VISIBLE
            isFullScreen = !isFullScreen
        }else {
            super.onBackPressed()
        }

    }

}