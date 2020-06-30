package com.example.dependencyinjectionexample.login.data.local

import com.example.dependencyinjectionexample.login.data.models.User

interface LoginLocalDS {

    fun insertUser(user: User): Long
}