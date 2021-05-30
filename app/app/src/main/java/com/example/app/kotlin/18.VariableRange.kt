package com.example.app.kotlin

var number : Int = 10


// 변수의 종류
// 1. 지역변수
// 2. 전역변수
fun main(args : Array<String>) {
    println(number)

    val test = Test("홍길동")
    test.name
    test.testFun()
    println(number)
}

class Test(var name : String) {
            // 전역변수
    fun testFun(){
        var birth : String = "2000/3/1" // 지역변수
        name = "홍길동"
        number = 100
        fun testFun2() {
            var gender : String = "남"
        }
    }
    fun testFun2(){
        name
        // birth 에러
    }

}