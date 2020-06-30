package com.example.dependencyinjectionexample.login.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencyinjectionexample.login.data.LoginDataManager
import com.example.dependencyinjectionexample.login.data.models.User

class LoginViewModel(val loginDataManager: LoginDataManager): ViewModel() {

    private val _userLiveData =  MutableLiveData<User?>()
    val userLiveData: LiveData<User?>
    get() = _userLiveData

    private val _insertUserData = MutableLiveData<Long>()
    val insertUserData: LiveData<Long>
    get() = _insertUserData

    fun login(userName:String, password: String){
        val user = loginDataManager.getUserBy(userName, password)
        user?.let {
            _insertUserData.postValue(loginDataManager.insertUser(it))
        }

        _userLiveData.postValue(user)
    }

}