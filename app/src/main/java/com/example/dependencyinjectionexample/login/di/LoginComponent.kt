package com.example.dependencyinjectionexample.login.di

import com.example.dependencyinjectionexample.ApplicationComponent
import com.example.dependencyinjectionexample.base.PerActivity
import com.example.dependencyinjectionexample.login.views.LoginActivity
import dagger.Component
import javax.inject.Singleton


@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [LoginModule::class])
interface LoginComponent {

    fun inject(loginActivity: LoginActivity)
}