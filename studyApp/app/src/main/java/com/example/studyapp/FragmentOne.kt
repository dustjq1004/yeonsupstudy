package com.example.studyapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : Fragment(){

    interface  OnDataPassListener {
        fun onDataPass(data : String?)
    }

    lateinit var dataPassListener : OnDataPassListener

    override fun onAttach(context: Context) {
        Log.d("life_cycle", "onAttach")
        super.onAttach(context)
        dataPassListener = context as OnDataPassListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "onCreate")
        super.onCreate(savedInstanceState)
    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        pass.setOnClickListener{
            dataPassListener.onDataPass("Good Bye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "onActivityCreated")
        val data = arguments?.getString("hello", "")
        Log.d("data", data.toString())
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle", "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDetach() {
        super.onDetach()
    }
}