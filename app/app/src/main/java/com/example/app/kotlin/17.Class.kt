package com.example.app.kotlin

// 클래스

// OOP -> Object Oriented Programing
// 객체 만들기
class Car(var engine : String, var body:String) {

}

class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine : String, body : String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

// 클래스 만들기 (3) -> 1번 방법의 확장
class Car1(engine: String, body: String) {
    var door: String = ""

    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door
    }
}

// 클래스 만들기 (4) -> 2번 방법의 확장
class Car2 {
    var engine: String = ""
    var body: String = ""
    var door: String = ""

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class RunableCar(engine: String, body: String) {

    fun ride() {
        println("탑승 하였습니다.")
    }

    fun drive() {
        println("달립니다 !")
    }

    fun navi(destination : String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }
}

class RunableCar2 {

    var engine: String
    var body: String

    constructor(engine : String, body : String) {
        this.engine = engine
        this.body = body
    }

    init {
        println("RunableCar2가 만들어 졌습니다.")
    }

    fun ride() {
        println("탑승 하였습니다.")
    }

    fun drive() {
        println("달립니다 !")
    }

    fun navi(destination : String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }

}

fun main(array: Array<String>) {

    val car = Car("v* engine", "big") // -> 인스턴스(객체)
    var bigCar : Car = Car("v* engine", "big")
    var superCar : SuperCar =  SuperCar("good Engine", "big", "white")

    var runableCar: RunableCar = RunableCar("simple engine", "short body")
    runableCar.ride()
    runableCar.drive()
    runableCar.navi("우리집")

    // 멤버변수 접근 방법
    val runableCar2 : RunableCar2 = RunableCar2("nice engine", "long body")
    runableCar2.body
    runableCar2.engine

}






