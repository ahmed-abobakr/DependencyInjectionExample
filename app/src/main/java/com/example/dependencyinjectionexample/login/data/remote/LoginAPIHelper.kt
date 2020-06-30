package com.example.dependencyinjectionexample.login.data.remote

import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.login.data.models.User

class LoginAPIHelper(val apiHelper: APIHelper):
    LoginRemoteDS {
    override fun getUserBy(userName: String, password: String): User? {
        if(userName.isNotEmpty() && password.length > 6){
            return User(
                userName,
                password,
                "ASDR12443JFDJF43543J543H3K543"
            )
        }
        return null
    }
}