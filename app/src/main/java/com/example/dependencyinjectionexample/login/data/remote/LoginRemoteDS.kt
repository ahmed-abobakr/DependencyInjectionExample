package com.example.dependencyinjectionexample.login.data.remote

import com.example.dependencyinjectionexample.login.data.models.User

interface LoginRemoteDS {

    fun getUserBy(userName: String, password: String): User?
}