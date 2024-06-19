package com.example.fundamentalskotlin

class MyClass {
    companion object{
        @JvmStatic

        fun main(args: Array<String>){

            //Pair
            var (a,b) = Pair("A", 1)
            println("$a $b")

            val name = Pair("shruti", Pair("Rani", 1))
            println("${name.first} ${name.second.second}")

            //Triple
                var(X,Y,Z) = Triple("A", "BOB", 23)
            println("$X $Y $Z");




        }
    }
}