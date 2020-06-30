package com.example.dependencyinjectionexample.news_list.data.remote

import com.example.dependencyinjectionexample.news_list.data.models.News

interface NewsRemoteDS {

    fun getNews(): List<News>
    fun getNewsById(id: Long): News?
}