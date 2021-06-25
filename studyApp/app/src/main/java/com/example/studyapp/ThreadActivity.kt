package com.example.studyapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)



        val runnable : Runnable = object  : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread is made")
            }
        }
        val thread : Thread = Thread(runnable)


        button.setOnClickListener{
            thread.start()
        }

        Thread(object  : Runnable{
            override fun run() {
                Log.d("thread-2", "Thread is made")

            }
        }).start()

        Thread(Runnable {
            Log.d("thread-3", "Thread is made")
            Thread.sleep(1000)
            runOnUiThread {
               // button.setBackgroundColor(getColor(R.color.teal_700)
            }

        }).start()


    }
}