package com.example.dependencyinjectionexample.login.data

import com.example.dependencyinjectionexample.login.data.local.LoginLocalDS
import com.example.dependencyinjectionexample.login.data.models.User
import com.example.dependencyinjectionexample.login.data.remote.LoginRemoteDS
import javax.inject.Inject

class LoginDataManagerImpl @Inject constructor(val loginRemoteDS: LoginRemoteDS, val loginLocalDS: LoginLocalDS):
    LoginDataManager {
    override fun insertUser(user: User): Long {
        return loginLocalDS.insertUser(user)
    }

    override fun getUserBy(userName: String, password: String): User? {
        return loginRemoteDS.getUserBy(userName, password)
    }
}