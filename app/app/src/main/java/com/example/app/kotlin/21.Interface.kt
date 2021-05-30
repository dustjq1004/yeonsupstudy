package com.example.app.kotlin

// 21. Interface
// 생성자가 없다 -> 객체화 할 수 없음.
// 인터페이스는 설명서가 아닌 지침서라 생각할 수 있다.
// 인터페이스를 상속받으면 인터페이스에 정의되어있는 모든 메소드를 구현해야함.(강제)
fun main(args: Array<String>) {

    val student_ : Student_ = Student_()
    student_.eat()
    student_.sleep()

}

interface Person_{
    fun eat()
    fun sleep()
}
class Student_: Person_ {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }
}

class SoccerPlay : Person_{
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

}

open class Person() {
    open fun eat() {

    }
    fun sleep(){

    }
}

class Student() : Person() {
    override fun eat() {
        super.eat()
    }
}

class Teacher() : Person() {

}
