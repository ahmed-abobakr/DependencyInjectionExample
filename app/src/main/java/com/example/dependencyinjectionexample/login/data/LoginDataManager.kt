package com.example.dependencyinjectionexample.login.data

import com.example.dependencyinjectionexample.login.data.local.LoginLocalDS
import com.example.dependencyinjectionexample.login.data.remote.LoginRemoteDS

interface LoginDataManager: LoginLocalDS,
    LoginRemoteDS {
}