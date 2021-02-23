package com.example.test1.data.repo

import android.content.Context

import com.example.test1.data.JsonSource
import com.example.test1.data.model.News

class Repository(context: Context) {
    private val librarySource = JsonSource(context = context)
    fun getNewsList(): List<News>  = librarySource.getNewsList()


}