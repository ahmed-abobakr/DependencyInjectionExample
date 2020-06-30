package com.example.dependencyinjectionexample.login.di

import android.content.Context
import com.example.dependencyinjectionexample.ApplicationComponent
import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.base.DBHelper
import com.example.dependencyinjectionexample.login.data.LoginDataManager
import com.example.dependencyinjectionexample.login.data.LoginDataManagerImpl
import com.example.dependencyinjectionexample.login.data.local.LoginDbHelper
import com.example.dependencyinjectionexample.login.data.remote.LoginAPIHelper
import com.example.dependencyinjectionexample.login.viewmodels.LoginViewModel
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun provideLoginAPIHelper(apiHelper: APIHelper) = LoginAPIHelper(apiHelper)

    @Provides
    fun provideLoginDbHelper(dbHelper: DBHelper) = LoginDbHelper(dbHelper)

    @Provides
    fun provieLoginDataManger(loginAPIHelper: LoginAPIHelper, loginDbHelper: LoginDbHelper): LoginDataManager =
        LoginDataManagerImpl(loginAPIHelper, loginDbHelper)

    @Provides
    fun  provideLoginViewModel(loginDataManager: LoginDataManager) = LoginViewModel(loginDataManager)
}