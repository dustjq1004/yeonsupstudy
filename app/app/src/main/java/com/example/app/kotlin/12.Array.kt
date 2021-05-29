package com.example.app.kotlin

// 12. 배열

fun main(array: Array<String>) {

    val one: Int = 1
    val two: Int = 2
    val three: Int = 3
    val four: Int = 4
    val five: Int = 5

    // 배열 생성 (1)
    var group1 = arrayOf<Int>(1, 2, 3, 4, 5)

    println(group1 is Array)

    // 배열 생성 (2)
    var group2 = arrayOf(1, 2, 3.5, 4, "Hello")

    // 배열 꺼내기 (1)
    val test1 = group1.get(0)
    val test2 = group1.get(4)
    val test3 = group1.get(2)
    println(test1)
    println(test2)
    println(test3)

    // 배열 꺼내기 (2)
    val test4 = group1[0]
    println(test4)

    // 배열 넣기 (1)
    group1.set(0, 100)
    println(group1[0])


    // 배열 넣기 (2)
    group1[0] = 200
    println(group1[0])
}
