package com.example.test1.data

import android.content.Context
import com.example.test1.Mapper
import com.example.test1.data.model.News
import kotlinx.serialization.UnstableDefault


class JsonSource(private val context: Context) {

    private val filename = "TestJson.json"

    @OptIn(UnstableDefault::class)
    fun getNewsList(): List<News> {

        val jsonNews =
            context.assets.open(filename).bufferedReader().use { it.readText() }
        return Mapper.fromJson(jsonNews)
    }

}