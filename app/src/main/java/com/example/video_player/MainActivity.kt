package com.example.video_player

import android.net.Uri
import android.os.Bundle
import android.net.Uri.parse // Esto es para que puedas usar parse() directamente
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.video_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val videoView = findViewById<VideoView>(binding.testView.id)

        //Creating media controller
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        //Specify the location of media file
        val uri: Uri = parse("android.resource://" + packageName + "/raw/test")
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

    }
}
