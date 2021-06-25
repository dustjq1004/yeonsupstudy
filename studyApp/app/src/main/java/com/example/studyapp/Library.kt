package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library.*

class Library : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        Glide.with(this@Library)
                .load("https://hamonikr.org/files/attach/images/118/310/070/d79db7380d8f96b4990147e7dbc75f08.jpg")
                .into(glide)
    }
}