package com.example.dependencyinjectionexample.news_details.di

import com.example.dependencyinjectionexample.ApplicationComponent
import com.example.dependencyinjectionexample.base.PerActivity
import com.example.dependencyinjectionexample.login.di.LoginModule
import com.example.dependencyinjectionexample.login.views.LoginActivity
import com.example.dependencyinjectionexample.news_details.views.NewsDetailsFragment
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class] ,  modules = [NewsDetailsModule::class])
interface NewsDetailsComponent {
    fun inject(newsDetailsFragment: NewsDetailsFragment)
}