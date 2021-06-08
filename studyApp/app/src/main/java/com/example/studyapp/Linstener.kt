package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_linstener.*
import java.util.*

class Linstener : AppCompatActivity() {
    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linstener)

        // 1. findViewVyId()
        // val textView : TextView = findViewById(R.id.hello)
        // 2.android-extension
        // hello


        // 1. 람다
        hello.setOnClickListener {
            Log.d("click", "Click!!")
        }

        // 2. 익명함수
        hello.setOnClickListener { object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
            }
        }}

        // 3. 변수할당
        var click = object : View.OnClickListener {
            override fun onClick(v: View?) {
                hello.setText("안녕하세요")
                image.setImageResource(R.drawable.ic_launcher_foreground)
                number += 10
                Log.d("number", ""+number)
            }
        }

        hello.setOnClickListener(click)


        // 뷰를 조작 하는 함수들
        // setText : 텍스트 변경
        // setImageResource : 이미지 리소스 변경

    }
}



