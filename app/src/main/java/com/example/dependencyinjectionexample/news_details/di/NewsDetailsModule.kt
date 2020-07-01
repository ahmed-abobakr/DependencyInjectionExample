package com.example.dependencyinjectionexample.news_details.di

import android.content.Context
import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.login.data.local.LoginDbHelper
import com.example.dependencyinjectionexample.login.data.remote.LoginAPIHelper
import com.example.dependencyinjectionexample.news_details.viewmodels.NewsDetailsViewModel
import com.example.dependencyinjectionexample.news_list.data.NewsDataManager
import com.example.dependencyinjectionexample.news_list.data.NewsDataManagerImpl
import com.example.dependencyinjectionexample.news_list.data.remote.NewsAPI
import com.example.dependencyinjectionexample.news_list.data.remote.NewsRemoteDS
import dagger.Module
import dagger.Provides

@Module
class NewsDetailsModule {

    @Provides
    fun providesNewsApiHelper(apiHelper: APIHelper) = NewsAPI(apiHelper)

    @Provides
    fun providesNewsDataManger(newsAPIHelper: NewsAPI): NewsDataManager =
        NewsDataManagerImpl(newsAPIHelper)


    @Provides
    fun providesNewsDetailsViewModel(newsDataManger: NewsDataManagerImpl) =
        NewsDetailsViewModel(newsDataManger)

    /**
    val apiHelper = APIHelper(activity!!.applicationContext)  [exists in application component]
    val newsAPIHelper = NewsAPI(apiHelper)                    [have to provide ]
    val newsDataManager = NewsDataManagerImpl(newsAPIHelper)  [have to provide ]
    viewModel = NewsDetailsViewModel(newsDataManager)         [have to provide]  */
}