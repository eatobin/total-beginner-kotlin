package com.kotlination.jsonstring

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

fun main(args: Array<String>) {

    val json = """{"name": "Kolineer", "age": "26", "messages" : ["Master Kotlin","At Kolination"]}"""
    val gson = GsonBuilder().setPrettyPrinting().create()

    println("=== Map from JSON ===")
    val personMap: Map<String, Any> = gson.fromJson(json, object : TypeToken<Map<String, Any>>() {}.type)
    personMap.forEach { println(it) }

    println("=== Map to JSON ===")
    val jsonPersonMap: String = gson.toJson(personMap)
    println(jsonPersonMap)
}
