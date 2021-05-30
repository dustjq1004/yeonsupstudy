package com.example.app.kotlin


// 상속이란
// 부모로부터 설명서를 물려받는다!
fun main(args: Array<String>) {
    val superCar100 : SuperCar100 = SuperCar100()
    println(superCar100.drive())
    superCar100.stop()

}


class InheritCar() {
    fun drive(){}
    fun strop(){}

}

open class Car100(){
    open fun drive():String {
        return "달린다"
    }
    fun stop() {

    }
}

class SuperCar100() : Car100() {
    override fun drive():String {
        val run = super.drive()
        return "빨리 $run"

    }
}

class Bus100() : Car100() {

}