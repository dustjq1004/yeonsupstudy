package com.example.app.kotlin

fun main (array : Array<String>){



    val testAccess : TestAccess = TestAccess("아무개")
    //testAccess.test()
    //println(testAccess.name)
    testAccess.changeName("아무개2")
    //println(testAc cess.name)

    val reward : Reward = Reward()
    reward.rewardAmount = 2000

    val runningCar: RunningCar = RunningCar()
    runningCar.runFast()
//    runningCar.run()
}

class Reward() {
    var rewardAmount: Int = 1000

}


class TestAccess{
    private var name : String = "홍길동"
    constructor(name : String) {
        this.name = name
    }

    fun changeName(newName : String) {
        this.name = newName
    }
    private fun test() {
        println("테스트")
    }





}

class RunningCar() {

    fun runFast() {
        run()
    }

    private fun run() {

    }
}