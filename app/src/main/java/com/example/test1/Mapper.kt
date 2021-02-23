package com.example.test1


import com.example.test1.data.model.News
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json


@UnstableDefault
object Mapper {
    private const val TAG = "Mapper"



    fun fromJson(json: String): List<News> =
        try {
            val list = Json.parse(News.serializer().list, json)
            list
        } catch (e: Throwable) {
            e.printStackTrace()
            emptyList()
        }

}