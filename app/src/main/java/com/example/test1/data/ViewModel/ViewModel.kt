package com.example.test1.data.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.test1.data.model.News
import com.example.test1.data.repo.Repository

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)
    val listNewsLiveData = MutableLiveData<List<News>>()

    fun getNews() {
        listNewsLiveData.postValue(repository.getNewsList())
    }

}