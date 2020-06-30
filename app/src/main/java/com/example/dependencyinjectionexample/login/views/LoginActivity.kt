package com.example.dependencyinjectionexample.login.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjectionexample.MainActivity
import com.example.dependencyinjectionexample.R
import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.base.DBHelper
import com.example.dependencyinjectionexample.login.data.LoginDataManagerImpl
import com.example.dependencyinjectionexample.login.data.local.LoginDbHelper
import com.example.dependencyinjectionexample.login.data.remote.LoginAPIHelper
import com.example.dependencyinjectionexample.login.viewmodels.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val apiHelper = APIHelper(applicationContext)
        val dbHelper = DBHelper(applicationContext, "users", 1)
        val loginAPIHelper = LoginAPIHelper(apiHelper)
        val loginDBHelper = LoginDbHelper(dbHelper)
        val loginDataManager = LoginDataManagerImpl(loginAPIHelper, loginDBHelper)
        viewModel = LoginViewModel(loginDataManager)

        loginBtn.setOnClickListener {
            viewModel.login(editUserName.text.toString(), editPassword.text.toString())
        }

        viewModel.insertUserData.observe(this, Observer {long ->
            if(long > 0){
                startActivity(Intent(this, MainActivity::class.java))
            }else {
                Toast.makeText(this, "Invalid Login Credentials", Toast.LENGTH_LONG).show()
            }
        })
    }
}