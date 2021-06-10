package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.studyapp.FragmentOne.OnDataPassListener
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), OnDataPassListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "onCreate")
        val fragmentOne : FragmentOne = FragmentOne()
        button.setOnClickListener{
            // 프래그먼트를 동적으로 작동하는 방법

            val fragmentManager : FragmentManager = supportFragmentManager
            // fragment data 넣기
            val bundle : Bundle = Bundle()
            bundle.putString("hello", "hello")
            fragmentOne.arguments = bundle

            // Transaction
            // 작업의 단위 -> 시작과 끝이 존재한다.
            // replace/add
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragmentOne)
            fragmentTransaction.commit()
            // 끝을 내는 방법
            // commit -> 시간 될때
            // commitnow -> 지금당장
        }

        button2.setOnClickListener{
            // remove/detach
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragmentOne)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }

    override fun onDataPass(data: String?) {
        Log.d("pass", "" + data)
    }

}