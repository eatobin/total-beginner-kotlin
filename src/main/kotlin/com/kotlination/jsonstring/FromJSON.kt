//package com.kotlination.jsonstring
//
//import com.github.salomonbrys.kotson.fromJson
//import com.google.gson.Gson
//import java.io.FileReader
//
//fun main(args: Array<String>) {
//
////    val json = """{"name": "Kolineer", "age": "26", "messages" : ["Master Kotlin","At Kolination"]}"""
//    val json = "{\"name\": \"Eric\", \"age\": \"60\", \"messages\" : [\"Master Kotlin\",\"At Kolination\"]}"
//    val gson = Gson()
//
//    val person1: Person = gson.fromJson(json, Person::class.java)
//    println(person1)
//
//    val person2: Person = gson.fromJson(FileReader("person.json"), Person::class.java)
//    /* content of person.json
//    {
//      "name" : "Kolineer",
//      "age" : 28,
//      "messages" : [ "To be Kotlin Master", "At Kotlination" ]
//    }
//    */
//    println(person2)
//
//    val person3: Person = gson.fromJson(json)
//    println(person3)
//
//    val person4: Person = gson.fromJson(FileReader("person.json"))
//    println(person4)
//}
