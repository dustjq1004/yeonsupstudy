package com.example.studyapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment 가 인터페이스를 처음으로 그릴 때 호출된다.
        // inflater -> 뷰를 그린다.
        // container -> 부모뷰
        Log.d("life_cycle", "onCreateView")
        return inflater.inflate(R.layout.fragment_one, container, false)
    }
}