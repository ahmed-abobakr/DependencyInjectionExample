package com.example.dependencyinjectionexample.news_list.di

import android.content.Context
import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.news_list.data.NewsDataManager
import com.example.dependencyinjectionexample.news_list.data.NewsDataManagerImpl
import com.example.dependencyinjectionexample.news_list.data.models.NewsListModel
import com.example.dependencyinjectionexample.news_list.data.remote.NewsAPI
import com.example.dependencyinjectionexample.news_list.view_models.NewsListViewModel
import dagger.Module
import dagger.Provides

@Module
class NewsListModule {

    @Provides
    fun providesNewsAPI(apiHelper: APIHelper) = NewsAPI(apiHelper)

    @Provides
    fun provideNewsDataManager(newsAPI: NewsAPI): NewsDataManager = NewsDataManagerImpl(newsAPI)

    @Provides
    fun providesNewsListViewModel(newsDataManager: NewsDataManager) = NewsListViewModel(newsDataManager)

    @Provides
    fun provideNewsListModel() = NewsListModel(emptyList())

}