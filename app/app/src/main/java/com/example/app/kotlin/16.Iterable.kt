package com.example.app.kotlin

// 16. Iterable

fun main (array: Array<String>) {

    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // for
    for (item in a) {
        if(item == 5) {
            println(item)
        } else {
            println("x")
        }
    }
    println()
    // for with index
    for ( (index, item) in a.withIndex()) {
        println("index : " + index + " value : " + item)
    }
    println()

    // forEach
    a.forEach {
        println(it)
    }
    println()
    // forEach (2)
    a.forEach { item ->
        println(item)
    }

    // forEach with Index
    a.forEachIndexed { index, item ->
        println("index : " + index + " value : " + item)
    }

    // for index 만
    for (i in 0 until a.size) {
        // until은 마지막을 포함 하지 않는다.
        println(a.get(i))
    }
    println()
    // for index 증가 수 설정
    for (i in 0 until a.size step (2)) {
        println(a.get(i))
    }

    println()

    // downTo
    for (i in a.size - 1 downTo (0)) {
        println(a.get(i))
    }

    println()
    // downTo step
    for( i in a.size - 1 downTo (0) step (2)) {
        println(a.get(i))
    }

    println()

    // .. 뒤에 까지 포함하여 for문 실행
    for( i in 0..10) {
        println(i)
    }

    // while문
    var b:Int = 0
    var c:Int = 4

    while (b < c) {
        b++
        println("b")
    }

    do{
        println("hello")
        b++
    } while ( b < c )

}











