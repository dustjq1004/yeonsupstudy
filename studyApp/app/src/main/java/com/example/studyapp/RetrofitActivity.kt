package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        service.getStudentsList().enqueue(object : Callback<ArrayList<Person>> {
            override fun onResponse(
                call: Call<ArrayList<Person>>,
                response: Response<ArrayList<Person>>
            ) {
                if (response.isSuccessful) {
                    val personList = response.body()
                    Log.d("retrofit", "res : " + personList?.get(0)?.age)

                    val code = response.code()
                    val error = response.errorBody()
                    val header = response.headers()

                }
            }

            override fun onFailure(call: Call<ArrayList<Person>>, t: Throwable) {

            }

        })

        val person = Person(name = "김아중", age = 22, intro = "안녕?")
        service.createStudentEasy(person).enqueue(object : Callback<Person>{
            override fun onResponse(call: Call<Person>, response: Response<Person>) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name : " + person?.name)
                }
            }

            override fun onFailure(call: Call<Person>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


//        val params = HashMap<String, Any>()
//        params.put("name", "홍길동")
//        params.put("age", 23)
//        params.put("intro", " 안녕하세요")
//        service.createStudents(params).enqueue(object :  Callback<Person>{
//            override fun onResponse(call: Call<Person>, response: Response<Person>) {
//                if(response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("retrofitt", "name : " + person?.name)
//                }
//            }
//
//            override fun onFailure(call: Call<Person>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })

    }

}