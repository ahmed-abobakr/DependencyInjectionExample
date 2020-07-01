package com.example.dependencyinjectionexample

import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.base.DBHelper
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: App)

    fun provideAPIHelper(): APIHelper

    fun provideDBHelper(): DBHelper
}