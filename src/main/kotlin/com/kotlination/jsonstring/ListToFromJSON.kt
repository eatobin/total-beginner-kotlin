//package com.kotlination.jsonstring
//
//import com.github.salomonbrys.kotson.fromJson
//import com.github.salomonbrys.kotson.typedToJson
//import com.google.gson.GsonBuilder
//import com.google.gson.reflect.TypeToken
//
//fun main(args: Array<String>) {
//
//    val jsonList = """[{"name": "Ericky", "age": "26", "messages" : ["Master Kotlin","At Kolination"]},
//			{"name":"Kolineer Master","age":30,"messages":["I am Kotlin Master","still learning Kotlin at Kotlination"]}]"""
//
//    val gson = GsonBuilder().setPrettyPrinting().create()
//
//    println("=== List from JSON ===")
//    val personList: List<Person> = gson.fromJson(jsonList, object : TypeToken<List<Person>>() {}.type)
//    personList.forEach { println(it) }
//
//    println("=== List2 from JSON ===")
//    val personList2 = gson.fromJson<List<Person>>(jsonList)
//    personList2.forEach { println(it) }
//
//    println("=== List to JSON ===")
//    val jsonPersonList: String = gson.toJson(personList)
//    println(jsonPersonList)
//
//    println("=== List2 to JSON ===")
//    val jsonPersonList2 = gson.typedToJson(personList2)
//    println(jsonPersonList2)
//}
