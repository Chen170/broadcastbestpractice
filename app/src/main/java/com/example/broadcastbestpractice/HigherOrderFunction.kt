package com.example.broadcastbestpractice

/**
 *   created by 李大辰
 *   on 2020/4/29
 */
fun main() {
    val num1 = 100
    val num2 = 80
    val result1 = num1AndNum2(num1, num2) { n1, n2 -> n1 + n2 }
    val result2 = num1AndNum2(num1, num2) { n1, n2 -> n1 - n2 }
//    println("result1 is $result1")
//    println("result2 is $result2")
//    eatFruits()

    println("main begin")
    val str: String = ""
    printString(str) {
        println("lambda start")
        if (it.isEmpty()) return
        println("lambda end")
    }
    println("main end")
}

inline fun runRunnable(crossinline block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
}

inline fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

inline fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

//fun plus(num1: Int, num2: Int): Int {
//    return num1 + num2
//}
//
//fun minus(num1: Int, num2: Int): Int {
//    return num1 - num2
//}

fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

fun eatFruits() {
    val fruitsList = listOf("Apple", "Banana", "Watermelon", "Orange")
    val result = StringBuilder().build {
        append("Start eating fruits.\n")
        for (fruit in fruitsList) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())
}