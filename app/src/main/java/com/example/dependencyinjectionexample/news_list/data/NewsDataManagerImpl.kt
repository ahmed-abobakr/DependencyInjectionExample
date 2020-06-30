package com.example.dependencyinjectionexample.news_list.data

import com.example.dependencyinjectionexample.news_list.data.models.News
import com.example.dependencyinjectionexample.news_list.data.remote.NewsRemoteDS

class NewsDataManagerImpl(val newsRemoteDS: NewsRemoteDS) : NewsDataManager{


    override fun getNews(): List<News> = newsRemoteDS.getNews()

    override fun getNewsById(id: Long) = newsRemoteDS.getNewsById(id)

}