package com.example.app.kotlin

// 14. Collection

/*
*   -> List, Set, Map
*      = 자바와 동일 하지만 한번 만들면 변경 불가 = Immutable Collections
* */
fun main(args: Array<String>) {

    //List - 중복 o
    val numberList = listOf<Int>(1, 2, 3, 3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    //Set  - 중복 x
    val numberSet = setOf<Int>(1, 2, 3, 3)
    println(numberSet)
    numberSet.forEach {
        println(it)
    }

    //Map - Key, value 쌍
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
    println(numberMap)
    println("numberMap : " + numberMap.get("one"))

    // Mutable
    val mnumberList = mutableListOf<Int>(1, 2, 3)
    mnumberList.add(3, 4)
    println(numberList)

    val mNumberSet = mutableSetOf<Int>(1, 2, 3, 4, 4, 4)
    mNumberSet.add(10)
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    mNumberMap.put("two", 2)
    println(numberMap)


}