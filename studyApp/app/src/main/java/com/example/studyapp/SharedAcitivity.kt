package com.example.studyapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_acitivity.*

class SharedAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_acitivity)
        // SharedPreference
        val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
        /*
        // Mode
            - private : 생성한 application 에서만 사용가능
            - WORLD_READABLE : 읽을 수만 있다
            - WORLD_WRITEABLE : 기록도 가능
            - MULTI_PROCESS : 이미 호출되어 사용중인지 체크
            - APPEND : 기존 preference 에 신규로 추가
        */
        saveBtn.setOnClickListener{
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕히가세요")
            editor.commit()
        }


        button.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val value1 = sharedPreferences.getString("hello", "데이터 x1")
            val value2 = sharedPreferences.getString("goodbye", "데이터 x2")

            Log.d("key-value", "value : " + value1)
            Log.d("key-value", "value : " + value2)


        }

        deleteBtn.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove("hello")
            editor.commit()
        }

        deleteAllBtn.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()
        }

    }
}





