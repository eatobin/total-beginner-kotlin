package totalBeginner

import com.github.salomonbrys.kotson.fromJson
import com.github.salomonbrys.kotson.jsonArray
import com.github.salomonbrys.kotson.jsonObject
import com.github.salomonbrys.kotson.toJson
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.util.*

val obj: JsonObject = jsonObject(
        "name" to "kotson",
        "creation" to Date().time,
        "files" to 4
)


val arr: JsonArray = jsonArray("one", "two", 42, 21.5)

val obj2: JsonObject = jsonObject(
        "property" to "value",
        "array" to jsonArray(
                21,
                "fourty-two",
                jsonObject("go" to "hell")
        )
)

val pi = 42.toJson()         // java: new JsonPrimitive(42);
val pf = 42.21f.toJson()     // java: new JsonPrimitive(42.21f);
val pd = 42.21.toJson()      // java: new JsonPrimitive(42.21d);
val pc = 'c'.toJson()        // java: new JsonPrimitive('c');
val pz = true.toJson()       // java: new JsonPrimitive(true);
val os = "coucou".toJson()   // java: new JsonPrimitive("coucou");

val gson = Gson()
val list1 = gson.fromJson<List<Book>>("[{\"name\":\"Borrower1\",\"maxBooks\":1},{\"name\":\"Borrower2\",\"maxBooks\":2}]")
//[Book(title=null, author=null, borrower=null), Book(title=null, author=null, borrower=null)]
