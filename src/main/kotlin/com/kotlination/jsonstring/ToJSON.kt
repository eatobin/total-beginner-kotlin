//package com.kotlination.jsonstring
//
//import com.github.salomonbrys.kotson.jsonArray
//import com.github.salomonbrys.kotson.jsonObject
//import com.google.gson.GsonBuilder
//import com.google.gson.JsonArray
//import com.google.gson.JsonObject
//import java.util.*
//
//fun main(args: Array<String>) {
//
//    val gson = GsonBuilder().setPrettyPrinting().create()
//
//    val person = Person("Kolineer", 27, listOf("I am Kotlin Learner", "At Kotlination"))
//    val jsonPerson: String = gson.toJson(person)
//    println(jsonPerson)
//
//    val obj: JsonObject = jsonObject(
//            "name" to "kotson",
//            "creation" to Date().time,
//            "files" to 4
//    )
//    println(obj)
//
//    val arr: JsonArray = jsonArray("one", "two", 42, 21.5)
//    println(arr)
//
//    val obj2: JsonObject = jsonObject(
//            "property" to "value",
//            "array" to jsonArray(
//                    21,
//                    "fourty-two",
//                    jsonObject("go" to "hell")
//            )
//    )
//    println(obj2)
//}
