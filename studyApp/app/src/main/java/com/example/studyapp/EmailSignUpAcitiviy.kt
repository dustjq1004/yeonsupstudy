package com.example.studyapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_email_sign_up_acitiviy.*
import kotlinx.android.synthetic.main.fragment_one.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EmailSignUpAcitiviy : AppCompatActivity() {

    lateinit var usernameView : EditText
    lateinit var pw1View : EditText
    lateinit var pw2View : EditText
    lateinit var registerBtn : TextView
    lateinit var loginBtn : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if((application as MasterApplication).checkIsLogin()) {
            startActivity(
                Intent(this@EmailSignUpAcitiviy, OutStargramPostListActivity::class.java)
            )
        } else {

            setContentView(R.layout.activity_email_sign_up_acitiviy)
            initView(this@EmailSignUpAcitiviy)
            setUpListener(this)
        }

    }

    fun setUpListener(activity: Activity) {
        registerBtn.setOnClickListener {
            register(this)
        }
        loginBtn.setOnClickListener {
            startActivity(
                Intent(this@EmailSignUpAcitiviy, loginActivity::class.java)
            )
        }
    }

    fun initView(activity: Activity) {
        usernameView = activity.findViewById(R.id.username_inputbox)
        pw1View = activity.findViewById(R.id.password1_inputbox)
        pw2View = activity.findViewById(R.id.password2_inputbox)
        registerBtn = activity.findViewById(R.id.register)
        loginBtn = activity.findViewById(R.id.login)

    }

    fun register(activity: Activity) {
        val username = getUserName()
        val password1 = getUserPassword1()
        val password2  = getUserPassword2()


        (application as MasterApplication).service.register(
                username, password1, password2
        ).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful) {
                    Toast.makeText(activity, "가입에 성공 하였습니다.", Toast.LENGTH_LONG).show()
                    val user = response.body()
                    val token = user!!.token!!
                    saveUserToken(token, activity)
                    (application as MasterApplication).createRetrofit()
                    activity.startActivity(
                        Intent(activity, OutStargramPostListActivity::class.java)
                    )
                }

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity, "가입에 실패 하였습니다.", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun saveUserToken(token: String, activity: Activity){
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }

    fun getUserName():String {
        return usernameView.text.toString()
    }

    fun getUserPassword1():String{
        return pw1View.text.toString()
    }

    fun getUserPassword2():String{
        return pw2View.text.toString()
    }

}