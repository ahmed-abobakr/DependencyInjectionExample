package com.example.dependencyinjectionexample

import android.content.Context
import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.base.DBHelper
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val context: Context) {

    @Provides
    fun provideAPIHelper() = APIHelper(context)

    @Provides
    fun provideDBHelper(dbName: String, dbVersion: Int) = DBHelper(context, dbName, dbVersion)

    @Provides
    fun provideDBName() = "users"

    @Provides
    fun provideDbVersion() = 1
}