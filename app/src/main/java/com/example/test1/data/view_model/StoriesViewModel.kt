package com.example.test1.data.view_model

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.AndroidViewModel
import com.example.test1.data.model.News
import com.example.test1.data.repo.Repository

class StoriesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)
    val listNewsLiveData = MutableLiveData<List<News>>()

    fun getNews() {
        listNewsLiveData.postValue(repository.getNewsList())
    }

}