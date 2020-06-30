package com.example.dependencyinjectionexample.news_list.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectionexample.news_list.data.NewsDataManager
import com.example.dependencyinjectionexample.news_list.data.models.NewsListModel

class NewsListViewModel(val newsDataManager: NewsDataManager): ViewModel() {

    private val _newsList = MutableLiveData<NewsListModel>()
    val newsList: LiveData<NewsListModel>
    get() = _newsList

    fun getNewsList(){
        _newsList.postValue(NewsListModel(newsDataManager.getNews()))
    }
}