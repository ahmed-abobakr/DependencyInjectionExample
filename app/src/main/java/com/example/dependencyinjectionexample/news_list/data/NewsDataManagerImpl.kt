package com.example.dependencyinjectionexample.news_list.data

import com.example.dependencyinjectionexample.news_list.data.models.News
import com.example.dependencyinjectionexample.news_list.data.remote.NewsRemoteDS
import javax.inject.Inject

class NewsDataManagerImpl @Inject constructor(val newsRemoteDS: NewsRemoteDS) : NewsDataManager{


    override fun getNews(): List<News> = newsRemoteDS.getNews()

    override fun getNewsById(id: Long) = newsRemoteDS.getNewsById(id)

}