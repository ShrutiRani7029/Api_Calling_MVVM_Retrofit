package com.example.fundamentalskotlin

fun main() {
    var obj = ClassObject(c=30);
    println("The Number Of classobject class : " + obj.num)

    println("Addition : " + obj.add(890,10))
}

class ClassObject() {
    var num=10;

//    init {
//        println("Primary Constructor : " + a)
//    }

    constructor(a:Int, b:Int) : this() {
        val sum = a+b;
     println("Secondary sum 2: " + sum)
    }

    constructor(a:Int =10, b:Int=20, c:Int) : this() { //default values in a,b but call wale arg ko jada preference milta hai
        val sum = a+b+c;
        println("Secondary sum 3: " + sum)
    }


    fun add(a:Int, b:Int) : Int {
        return a+b;
    }

}