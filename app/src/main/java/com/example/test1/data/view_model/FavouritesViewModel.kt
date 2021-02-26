package com.example.test1.data.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.test1.data.model.News
import com.example.test1.data.repo.Repository

class FavouritesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)
    val listFavouritesLiveData = MutableLiveData<MutableList<News>>()

    private fun getNews(): List<News> {
        return repository.getNewsList()
    }

    fun getFavourites() {

        val favorites = mutableListOf<News>()
        val listNews = getNews()

        listNews.forEach { oneNews ->

            if (oneNews.isFavourite) {
                favorites.add(oneNews)
            }
        }
        listFavouritesLiveData.value = favorites
    }

}