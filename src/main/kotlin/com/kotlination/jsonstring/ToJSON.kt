package com.kotlination.jsonstring

import com.google.gson.GsonBuilder

fun main(args: Array<String>) {

    val gson = GsonBuilder().setPrettyPrinting().create()

    val person = Person("Kolineer", 27, listOf("I am Kotlin Learner", "At Kotlination"))
    val jsonPerson: String = gson.toJson(person)
    println(jsonPerson)
}
