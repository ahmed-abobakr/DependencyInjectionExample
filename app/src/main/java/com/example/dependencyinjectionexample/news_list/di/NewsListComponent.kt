package com.example.dependencyinjectionexample.news_list.di

import com.example.dependencyinjectionexample.ApplicationComponent
import com.example.dependencyinjectionexample.base.PerActivity
import com.example.dependencyinjectionexample.news_list.views.NewsListFragment
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [NewsListModule::class])
interface NewsListComponent {

    fun inject(newsListFragment: NewsListFragment)
}