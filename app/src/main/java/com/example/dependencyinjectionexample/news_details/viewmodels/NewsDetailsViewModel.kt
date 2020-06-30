package com.example.dependencyinjectionexample.news_details.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectionexample.news_list.data.NewsDataManager
import com.example.dependencyinjectionexample.news_list.data.models.News

class NewsDetailsViewModel(private val newsDataManager: NewsDataManager): ViewModel() {

    private val _newsItem = MutableLiveData<News>()
    val newsItem: LiveData<News>
    get() = _newsItem

    fun getNewsItem(id: Long){
        _newsItem.postValue(newsDataManager.getNewsById(id))
    }
}