package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NullSafety : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)
    }
}