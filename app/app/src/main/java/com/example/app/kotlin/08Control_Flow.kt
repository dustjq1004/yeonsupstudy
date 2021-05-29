package com.example.app.kotlin

// 08. 제어 흐름이란 ? if else
fun main (args:Array<String>) {
    val a: Int = 5
    val b: Int = 10

    // if/else
    if (a > b) {
        println("a 가 b 보다 크다.")
    } else {
        println("a 가 b 보다 작다.")
    }

    // if/else (2)
    if (a > b) {
        println("a 가 b 보다 크다.")
    }

    // if//else/else if
    if (a > b){
        println("a 가 b 보다 크다.")
    } else if (a > b) {
        println("a 가 b 보다 작다.")
    } else if (a == b){
        println("a 와 b가 같다.")
    } else {

    }

    // 값을 리턴하는 if
    val max = if (a > b) {
        a
    } else {
        b
    }
    println()
    println(max)

    // 값을 리턴하는 if 생략
    val max1 = if (a > b) a else b

    println()
    println(max1)
}









